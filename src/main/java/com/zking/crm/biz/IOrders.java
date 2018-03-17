package com.zking.crm.biz;

import com.zking.crm.model.Orders;
import com.zking.crm.util.PageBean;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/13/013.
 */
public interface IOrders {

    List<Orders> list(Orders orders, PageBean pageBean);

    void add(Orders orders);

    void del(Orders orders);

    void edit(Orders orders);

    Orders load(Orders orders);

}
