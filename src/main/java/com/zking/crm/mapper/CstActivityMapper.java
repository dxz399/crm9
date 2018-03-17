package com.zking.crm.mapper;

import com.zking.crm.model.CstActivity;

import java.util.List;

public interface CstActivityMapper {
    int deleteByPrimaryKey(Integer atvId);

    int insert(CstActivity record);

    int insertSelective(CstActivity record);

    CstActivity selectByPrimaryKey(Integer atvId);

    int updateByPrimaryKeySelective(CstActivity record);

    int updateByPrimaryKey(CstActivity record);

    //根据客户
    List<CstActivity> list(CstActivity cstActivity);

}