package com.zking.crm.controller;

import com.zking.crm.biz.ICstCustomer;
import com.zking.crm.model.CstCustomer;
import com.zking.crm.util.JsonUtils;
import com.zking.crm.util.PageBean;
import com.zking.crm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Heyiyong on 2018/3/17/017.
 */
@Controller
@RequestMapping("/cust")
public class Dome {

    @Autowired
    private ICstCustomer cstCustomerBiz;

    @RequestMapping("/listDj")
    @ResponseBody
    public Map<String,Object> list(CstCustomer cstCustomer, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<CstCustomer> list = cstCustomerBiz.listDj(cstCustomer, pageBean);

        Map<String, Object> xmap = new HashMap<String,Object>();

        int [] dj = new int[list.size()];
        int [] sl = new int[list.size()];
        //定义数组下标
        int i = 0;
        for(CstCustomer x:list){
            dj[i] = x.getCustLevel();//等级
            sl[i] = x.getCustSatisfy();//数量
            i++;
        }
        System.out.println(list.size()+"-------------------ll");

        xmap.put("dj", dj);
        xmap.put("sl", sl);

        return xmap;
    }

}
