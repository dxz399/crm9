package com.zking.crm.mapper;

import com.zking.crm.model.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer odrId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer odrId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> list(Orders orders);
}