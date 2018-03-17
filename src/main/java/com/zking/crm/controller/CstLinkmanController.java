package com.zking.crm.controller;

import com.zking.crm.biz.ICstCustomer;
import com.zking.crm.biz.ICstLinkman;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.model.CstLinkman;
import com.zking.crm.util.JsonUtils;
import com.zking.crm.util.PageBean;
import com.zking.crm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/linkman")
public class CstLinkmanController {

    @Autowired
    private ICstLinkman cstLinkmanBiz;


    @RequestMapping("/list")
    public void list(CstLinkman cstLinkman, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        String lkmCustNo = request.getParameter("lkmCustNo");

        cstLinkman.setLkmCustNo(lkmCustNo);
        List<CstLinkman> list = cstLinkmanBiz.list(cstLinkman, pageBean);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    @RequestMapping("/delete")
    public void delete(CstLinkman cstLinkman,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String lkmId = request.getParameter("lkmId");
        cstLinkman.setLkmId(Integer.parseInt(lkmId));

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstLinkmanBiz.delete(cstLinkman);
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
    public CstLinkman toEdit(CstLinkman cstLinkman, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String lkmId = request.getParameter("lkmId");
        cstLinkman.setLkmId(Integer.parseInt(lkmId));
        CstLinkman c = cstLinkmanBiz.load(cstLinkman);
        return c;
    }


    //编辑联系人信息
    @RequestMapping("/edit")
    @ResponseBody
    public void edit(CstLinkman cstLinkman,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstLinkmanBiz.edit(cstLinkman);
        ResponseData responseData = new ResponseData();
        responseData.setMessage("编辑客户信息成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }


    //跳转到增加
    @RequestMapping("/toAdd")
    public String toAdd(CstLinkman cstLinkman, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String lkmCustNo = request.getParameter("lkmCustNo");
        String lkmCustName = request.getParameter("lkmCustName");
        request.getSession().setAttribute("lkmCustNo",lkmCustNo);
        request.getSession().setAttribute("lkmCustName",lkmCustName);
        return "cust/linkman_add";
    }


    //添加联系人
    @RequestMapping("/add")
    @ResponseBody
    public void add(CstLinkman cstLinkman, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        cstLinkmanBiz.add(cstLinkman);
        ResponseData responseData = new ResponseData();
        responseData.setMessage("添加成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
