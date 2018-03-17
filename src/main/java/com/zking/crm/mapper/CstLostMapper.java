package com.zking.crm.mapper;

import com.zking.crm.model.CstLost;

import java.util.List;

public interface CstLostMapper {
    int deleteByPrimaryKey(Integer lstId);

    int insert(CstLost record);

    int insertSelective(CstLost record);

    CstLost selectByPrimaryKey(Integer lstId);

    int updateByPrimaryKeySelective(CstLost record);

    int updateByPrimaryKey(CstLost record);

    List<CstLost> list(CstLost cstLost);
}