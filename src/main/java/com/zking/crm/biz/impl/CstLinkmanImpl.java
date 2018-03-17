package com.zking.crm.biz.impl;

import com.zking.crm.biz.ICstLinkman;
import com.zking.crm.mapper.CstLinkmanMapper;
import com.zking.crm.model.CstLinkman;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/11/011.
 */
@Service
public class CstLinkmanImpl implements ICstLinkman {

    @Autowired
    private CstLinkmanMapper cstLinkmanMapper;

    @Override
    public List<CstLinkman> list(CstLinkman cstLinkman, PageBean pageBean) {
        return cstLinkmanMapper.list(cstLinkman);
    }

    @Override
    public void add(CstLinkman cstLinkman) {
        cstLinkmanMapper.insert(cstLinkman);
    }

    @Override
    public void delete(CstLinkman cstLinkman) {
        cstLinkmanMapper.deleteByPrimaryKey(cstLinkman.getLkmId());
    }

    @Override
    public void edit(CstLinkman cstLinkman) {
        cstLinkmanMapper.updateByPrimaryKeySelective(cstLinkman);
    }

    @Override
    public CstLinkman load(CstLinkman cstLinkman) {
        return cstLinkmanMapper.selectByPrimaryKey(cstLinkman.getLkmId());
    }
}
