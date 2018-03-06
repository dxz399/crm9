package com.zking.crm.mapper;

import com.zking.crm.model.SalChange;

public interface SalChangeMapper {
    int deleteByPrimaryKey(Integer chcId);

    int insert(SalChange record);

    int insertSelective(SalChange record);

    SalChange selectByPrimaryKey(Integer chcId);

    int updateByPrimaryKeySelective(SalChange record);

    int updateByPrimaryKey(SalChange record);
}