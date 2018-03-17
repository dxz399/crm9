package com.zking.crm.biz.impl;

import com.zking.crm.biz.ICstCustomer;
import com.zking.crm.mapper.CstCustomerMapper;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/10/010.
 */
@Service
public class CstCustomerImpl implements ICstCustomer {

    @Autowired
    private CstCustomerMapper customerMapper;

    @Override
    public List<CstCustomer> list(CstCustomer cstCustomer, PageBean pageBean) {
        return customerMapper.list(cstCustomer);
    }

    @Override
    public List<CstCustomer> listDj(CstCustomer cstCustomer, PageBean pageBean) {
        return customerMapper.listDj(cstCustomer);
    }

    @Override
    public CstCustomer load(CstCustomer cstCustomer) {
        return customerMapper.selectByPrimaryKey(cstCustomer.getCustNo());
    }

    @Override
    public void add(CstCustomer cstCustomer) {
        customerMapper.insertSelective(cstCustomer);
    }

    @Override
    public void del(CstCustomer cstCustomer) {
        customerMapper.deleteByPrimaryKey(cstCustomer.getCustNo());
    }

    @Override
    public void edit(CstCustomer cstCustomer) {
        customerMapper.updateByPrimaryKeySelective(cstCustomer);
    }


}
