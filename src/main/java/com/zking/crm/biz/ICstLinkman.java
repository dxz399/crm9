package com.zking.crm.biz;

import com.zking.crm.model.CstLinkman;
import com.zking.crm.util.PageBean;

import java.util.List;

/**
 * Created by Heyiyong on 2018/3/11/011.
 */
public interface ICstLinkman {

    List<CstLinkman> list(CstLinkman cstLinkman, PageBean pageBean);

    void add(CstLinkman cstLinkman);

    void delete(CstLinkman cstLinkman);

    void edit(CstLinkman cstLinkman);

    CstLinkman load(CstLinkman cstLinkman);
    
}
