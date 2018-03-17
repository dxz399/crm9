package com.zking.crm.biz;

import com.zking.crm.model.Orders;
import com.zking.crm.model.OrdersLine;
import com.zking.crm.util.PageBean;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/13/013.
 */
public interface IOrdersLine {

    List<OrdersLine> list(OrdersLine ordersLine, PageBean pageBean);

    void add(OrdersLine ordersLine);

    void del(OrdersLine ordersLine);

    void edit(OrdersLine ordersLine);

    OrdersLine load(OrdersLine ordersLine);

}
