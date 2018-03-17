package com.zking.crm.biz;

import com.zking.crm.model.CstLost;
import com.zking.crm.util.PageBean;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/14/014.
 */
public interface ICstLost {

    List<CstLost> list(CstLost cstLost, PageBean pageBean);

    void add(CstLost cstLost);

    void del(CstLost cstLost);

    void edit(CstLost cstLost);

    CstLost load(CstLost cstLost);

}
