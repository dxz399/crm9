package com.zking.crm.mapper;

import com.zking.crm.model.CstLinkman;

import java.util.List;

public interface CstLinkmanMapper {
    int deleteByPrimaryKey(Integer lkmId);

    int insert(CstLinkman record);

    int insertSelective(CstLinkman record);

    CstLinkman selectByPrimaryKey(Integer lkmId);

    int updateByPrimaryKeySelective(CstLinkman record);

    int updateByPrimaryKey(CstLinkman record);

    //查询每个客户所对应的联系人
    List<CstLinkman> list(CstLinkman cstLinkman);
}