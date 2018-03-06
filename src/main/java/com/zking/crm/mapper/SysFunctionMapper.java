package com.zking.crm.mapper;

import com.zking.crm.model.SysFunction;

public interface SysFunctionMapper {
    int deleteByPrimaryKey(Integer functionId);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    SysFunction selectByPrimaryKey(Integer functionId);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}