package com.zking.crm.controller;

import com.zking.crm.biz.IOrders;
import com.zking.crm.biz.IOrdersLine;
import com.zking.crm.mapper.OrdersLineMapper;
import com.zking.crm.model.Orders;
import com.zking.crm.model.OrdersLine;
import com.zking.crm.util.JsonUtils;
import com.zking.crm.util.PageBean;
import com.zking.crm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/ordersLine")
public class OrdersLineController {

    @Autowired
    private IOrdersLine ordersLineBiz;
    @Autowired
    private IOrders ordersBiz;



    //跳转到订单明细jsp
    @RequestMapping("/toLine")
    public String toLine(OrdersLine ordersLine, HttpServletRequest request, HttpServletResponse response){
        String ordersId = request.getParameter("ordersId");
        System.out.println(ordersId+"----------------oooo");
        request.setAttribute("ordersId",ordersId);
        return "cust/orders_detail";
    }


    @RequestMapping("/list")
    public void list(OrdersLine ordersLine, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ordersId = request.getParameter("ordersId");
        ordersLine.setOddOrderId(Integer.parseInt(ordersId));

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        //查询订单详细
        List<OrdersLine> list = ordersLineBiz.list(ordersLine, pageBean);

        Orders orders = new Orders();
        //查询订单
        orders.setOdrId(Integer.parseInt(ordersId));
        orders = ordersBiz.load(orders);
        System.out.println(orders+"----------ssssssssssssssssssssss");
        request.getSession().setAttribute("orders",orders);

        ResponseData responseData = new ResponseData();
        responseData.setTotal(pageBean.getTotalRecord());
        responseData.setRows(list);

        response.setContentType("text/plain;charset=utf-8");
        OutputStream os = response.getOutputStream();
        JsonUtils.writeValue(os, responseData);
    }



}
