package com.zking.crm.biz.impl;

import com.zking.crm.biz.IOrdersLine;
import com.zking.crm.mapper.OrdersLineMapper;
import com.zking.crm.model.Orders;
import com.zking.crm.model.OrdersLine;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/13/013.
 */
@Service
public class OrdersLineImpl implements IOrdersLine {

    @Autowired
    private OrdersLineMapper ordersLineMapper;

    @Override
    public List<OrdersLine> list(OrdersLine ordersLine, PageBean pageBean) {
        return ordersLineMapper.list(ordersLine);
    }

    @Override
    public void add(OrdersLine ordersLine) {
        ordersLineMapper.insert(ordersLine);
    }

    @Override
    public void del(OrdersLine ordersLine) {
        ordersLineMapper.deleteByPrimaryKey(ordersLine.getOddId());
    }

    @Override
    public void edit(OrdersLine ordersLine) {
        ordersLineMapper.updateByPrimaryKeySelective(ordersLine);
    }

    @Override
    public OrdersLine load(OrdersLine ordersLine) {
        return ordersLineMapper.selectByPrimaryKey(ordersLine.getOddId());
    }
}
