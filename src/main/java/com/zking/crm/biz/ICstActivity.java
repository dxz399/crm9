package com.zking.crm.biz;

import com.zking.crm.model.CstActivity;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.util.PageBean;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/10/010.
 */
public interface ICstActivity {

    List<CstActivity> list(CstActivity cstActivity, PageBean pageBean);

    CstActivity load(CstActivity cstActivity);

    void add(CstActivity cstActivity);

    void del(CstActivity cstActivity);

    void edit(CstActivity cstActivity);

}
