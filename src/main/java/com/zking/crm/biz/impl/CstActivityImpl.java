package com.zking.crm.biz.impl;

import com.zking.crm.biz.ICstActivity;
import com.zking.crm.mapper.CstActivityMapper;
import com.zking.crm.model.CstActivity;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/12/012.
 */
@Service
public class CstActivityImpl implements ICstActivity {

    @Autowired
    private CstActivityMapper cstActivityMapper;

    @Override
    public List<CstActivity> list(CstActivity cstActivity, PageBean pageBean) {
        return cstActivityMapper.list(cstActivity);
    }

    @Override
    public CstActivity load(CstActivity cstActivity) {
        return cstActivityMapper.selectByPrimaryKey(cstActivity.getAtvId());
    }

    @Override
    public void add(CstActivity cstActivity) {
        cstActivityMapper.insert(cstActivity);
    }

    @Override
    public void del(CstActivity cstActivity) {
        cstActivityMapper.deleteByPrimaryKey(cstActivity.getAtvId());
    }

    @Override
    public void edit(CstActivity cstActivity) {
        cstActivityMapper.updateByPrimaryKeySelective(cstActivity);
    }
}
