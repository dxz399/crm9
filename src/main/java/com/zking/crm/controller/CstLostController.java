package com.zking.crm.controller;

import com.zking.crm.biz.ICstLinkman;
import com.zking.crm.biz.ICstLost;
import com.zking.crm.model.CstLinkman;
import com.zking.crm.model.CstLost;
import com.zking.crm.util.JsonUtils;
import com.zking.crm.util.PageBean;
import com.zking.crm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Heyiyong on 2018/3/10/010.
 */
@Controller
@RequestMapping("/lost")
public class CstLostController {

    @Autowired
    private ICstLost cstLostBiz;


    @RequestMapping("/list")
    public void list(CstLost cstLost, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        List<CstLost> list = cstLostBiz.list(cstLost, pageBean);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }


    //跳转到暂缓流失页面
    @RequestMapping("/toConfirm")
    public String toConfirm(CstLost cstLost, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String lstId = request.getParameter("lstId");
        cstLost.setLstId(Integer.parseInt(lstId));

        CstLost cstLost1 = cstLostBiz.load(cstLost);
        request.getSession().setAttribute("lost",cstLost1);
        return "lost/confirm";
    }

    //跳转到确认流失页面
    @RequestMapping("/toRelay")
    public String toRelay(CstLost cstLost, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String lstId = request.getParameter("lstId");
        cstLost.setLstId(Integer.parseInt(lstId));

        CstLost cstLost1 = cstLostBiz.load(cstLost);
        request.getSession().setAttribute("lost",cstLost1);
        return "lost/relay";
    }


    //确认客户流失
    @RequestMapping("/edit")
    @ResponseBody
    public void edit(CstLost cstLost,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        if(1==cstLost.getLstStatus()){//如果状态为预警的话就改为暂缓流失
            cstLost.setLstStatus(2);
        } else if (2 == cstLost.getLstStatus()) {//如果状态已经为暂缓流失就改为确认流失
            cstLost.setLstStatus(3);
        }
        java.sql.Date t = new java.sql.Date(System.currentTimeMillis());
        cstLost.setLstLostDate(t);
        cstLostBiz.edit(cstLost);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
