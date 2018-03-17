package com.zking.crm.biz.impl;

import com.zking.crm.biz.IOrders;
import com.zking.crm.mapper.OrdersMapper;
import com.zking.crm.model.Orders;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/13/013.
 */
@Service
public class OrdersImpl implements IOrders {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> list(Orders orders, PageBean pageBean) {
        return ordersMapper.list(orders);
    }

    @Override
    public void add(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public void del(Orders orders) {
        ordersMapper.deleteByPrimaryKey(orders.getOdrId());
    }

    @Override
    public void edit(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public Orders load(Orders orders) {
        return ordersMapper.selectByPrimaryKey(orders.getOdrId());
    }
}
