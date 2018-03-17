package com.zking.crm.biz.impl;

import com.zking.crm.biz.ICstLost;
import com.zking.crm.mapper.CstLostMapper;
import com.zking.crm.model.CstLost;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/14/014.
 */
@Service
public class CstLostImpl implements ICstLost {

    @Autowired
    private CstLostMapper cstLostMapper;

    @Override
    public List<CstLost> list(CstLost cstLost, PageBean pageBean) {
        return cstLostMapper.list(cstLost);
    }

    @Override
    public void add(CstLost cstLost) {
        cstLostMapper.insertSelective(cstLost);
    }

    @Override
    public void del(CstLost cstLost) {
        cstLostMapper.deleteByPrimaryKey(cstLost.getLstId());
    }

    @Override
    public void edit(CstLost cstLost) {
        cstLostMapper.updateByPrimaryKeySelective(cstLost);
    }

    @Override
    public CstLost load(CstLost cstLost) {
        return cstLostMapper.selectByPrimaryKey(cstLost.getLstId());
    }
}
