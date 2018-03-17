package com.zking.crm.controller;

import com.zking.crm.biz.ICstActivity;
import com.zking.crm.biz.ICstLinkman;
import com.zking.crm.model.CstActivity;
import com.zking.crm.model.CstLinkman;
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
@RequestMapping("/activity")
public class CstActivityController {

    @Autowired
    private ICstActivity cstActivityBiz;


    @RequestMapping("/list")
    public void list(CstActivity cstActivity, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("activitylist---------------------------");
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        String atvCustNo = request.getParameter("atvCustNo");

        cstActivity.setAtvCustNo(atvCustNo);
        List<CstActivity> list = cstActivityBiz.list(cstActivity, pageBean);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    @RequestMapping("/delete")
    public void delete(CstActivity cstActivity,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("activitydel---------------------------");
        String atvId = request.getParameter("atvId");
        cstActivity.setAtvId(Integer.parseInt(atvId));

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstActivityBiz.del(cstActivity);

        ResponseData responseData = new ResponseData();
        responseData.setMessage("删除成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    //跳转到编辑页面
    @RequestMapping("/load")
    @ResponseBody
    public CstActivity toEdit(CstActivity cstActivity, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("activityload---------------------------");
        String atvId = request.getParameter("atvId");
        cstActivity.setAtvId(Integer.parseInt(atvId));
        CstActivity c = cstActivityBiz.load(cstActivity);
        return c;
    }


    //编辑交易记录
    @RequestMapping("/edit")
    @ResponseBody
    public void edit(CstActivity cstActivity,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{

        System.out.println(cstActivity+"-------------edit");
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstActivityBiz.edit(cstActivity);

        ResponseData responseData = new ResponseData();
        responseData.setMessage("编辑交易记录成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    //跳转到添加交易记录
    @RequestMapping("/toAdd")
    public String toAdd(CstActivity cstActivity, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String atvCustNo = request.getParameter("atvCustNo");
        request.setAttribute("atvCustNo",atvCustNo);
        return "cust/activities_add";
    }


    //添加交易记录
    @RequestMapping("/add")
    @ResponseBody
    public void add(CstActivity cstActivity, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String atvCustNo = request.getParameter("atvCustNo");
        cstActivityBiz.add(cstActivity);

        ResponseData responseData = new ResponseData();
        responseData.setMessage("添加成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
