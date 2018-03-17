package com.zking.crm.controller;

import com.zking.crm.biz.ICstCustomer;
import com.zking.crm.biz.IOrders;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.model.Orders;
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
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrders ordersBiz;


    @RequestMapping("/list")
    public void list(Orders orders, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String odrCustomer = request.getParameter("odrCustomer");
        orders.setOdrCustomer(odrCustomer);

        System.out.println("-------------------list"+orders.getOdrCustomer());
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Orders> list = ordersBiz.list(orders, pageBean);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
