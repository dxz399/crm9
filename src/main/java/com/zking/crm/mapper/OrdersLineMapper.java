package com.zking.crm.mapper;

import com.zking.crm.model.OrdersLine;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrdersLineMapper {
    int deleteByPrimaryKey(Integer oddId);

    int insert(OrdersLine record);

    int insertSelective(OrdersLine record);

    OrdersLine selectByPrimaryKey(Integer oddId);

    int updateByPrimaryKeySelective(OrdersLine record);

    int updateByPrimaryKey(OrdersLine record);

    List<OrdersLine> list(OrdersLine ordersLine);

}