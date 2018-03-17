package com.zking.crm.biz;

import com.zking.crm.model.CstCustomer;
import com.zking.crm.util.PageBean;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/10/010.
 */
public interface ICstCustomer {

    List<CstCustomer> list(CstCustomer cstCustomer, PageBean pageBean);

    List<CstCustomer> listDj(CstCustomer cstCustomer, PageBean pageBean);

    CstCustomer load(CstCustomer cstCustomer);

    void add(CstCustomer cstCustomer);

    void del(CstCustomer cstCustomer);

    void edit(CstCustomer cstCustomer);

}
