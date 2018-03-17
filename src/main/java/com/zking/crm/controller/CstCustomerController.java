package com.zking.crm.controller;

import com.zking.crm.biz.ICstCustomer;
import com.zking.crm.model.CstCustomer;
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
@RequestMapping("/customer")
public class CstCustomerController {

    @Autowired
    private ICstCustomer cstCustomerBiz;


    @RequestMapping("/list")
    public void list(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<CstCustomer> list = cstCustomerBiz.list(cstCustomer, pageBean);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    @RequestMapping("/listDj")
    public void listDj(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<CstCustomer> list = cstCustomerBiz.listDj(cstCustomer,pageBean);
        System.out.println(list.size()+"---------------ll");
        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    @RequestMapping("/delete")
    public void delete(CstCustomer cstCustomer,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        cstCustomer.setCustNo(custNo);

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstCustomerBiz.del(cstCustomer);
        ResponseData responseData = new ResponseData();
        responseData.setMessage("删除成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }

    //查询单个客户信息
    @RequestMapping("/load")
    @ResponseBody
    public CstCustomer load(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        cstCustomer.setCustNo(custNo);
        CstCustomer c = cstCustomerBiz.load(cstCustomer);
        return c;
    }

    //跳转到编辑页面
    @RequestMapping("/toEdit")
    public String toEdit(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        request.getSession().setAttribute("custNo",custNo);
        return "cust/edit";
    }

    //跳转到联系人
    @RequestMapping("/linkman")
    public String toLinkman(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        cstCustomer.setCustNo(custNo);
        CstCustomer c = cstCustomerBiz.load(cstCustomer);
        request.getSession().setAttribute("cust",c);
        return "cust/linkman";
    }


    //跳转到交易记录
    @RequestMapping("/activity")
    public String toActivity(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        cstCustomer.setCustNo(custNo);
        CstCustomer c = cstCustomerBiz.load(cstCustomer);
        request.setAttribute("activity",c);
        return "cust/activities";
    }


    //跳转到历史记录
    @RequestMapping("/orders")
    public String toOrders(CstCustomer cstCustomer, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String custNo = request.getParameter("custNo");
        cstCustomer.setCustNo(custNo);
        CstCustomer c = cstCustomerBiz.load(cstCustomer);
        request.setAttribute("orders",c);
        return "cust/orders";
    }


    //编辑客户信息
    @RequestMapping("/edit")
    @ResponseBody
    public void edit(CstCustomer cstCustomer,  HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        cstCustomerBiz.edit(cstCustomer);
        ResponseData responseData = new ResponseData();
        responseData.setMessage("编辑客户信息成功");
        responseData.setCode(0);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
