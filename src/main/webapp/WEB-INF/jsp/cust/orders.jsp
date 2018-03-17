<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户编号</th>
        <td>${requestScope.orders.custNo}</td>
        <th>客户名称</th>
        <td>${requestScope.orders.custName}</td>
    </tr>
</table>
<br />
<table class="data_list_table" id="od">
</table>

<script type="text/javascript" >
    $(function() {
        $('#od').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'odrId',
            fitColumns:true,
            singleSelect : true,
            toolbar : [{
                iconCls : 'icon-application-form-magnify',
                text : '明细',
                handler : function() {
                    //获得被选中的行
                    var row = $('#od').datagrid("getSelected");
                        if (!row) {
                            $.messager.alert('警告', "请选择要查看的客户订单明细");
                            return;
                        }
                        //获取选中的行的ordersId
                        var odrId = row.odrId;
                        alert(odrId);
                        parent.addTab('查看订单明细','ordersLine/toLine?ordersId='+odrId,'icon-arrow-refresh-small',true);
                    }
                }],

            url : 'orders/list?odrCustomer='+'${requestScope.orders.custName}',
            columns : [ [ {
                field : 'odrId',
                width :'250',
                title:'订单编号'
            }, {
                field : 'odrCustomer',
                width :'250',
                title:'客户名称'
            }, {
                field : 'odrDate',
                width :'250',
                title:'下单时间'
            }, {
                field : 'odrAddr',
                width :'250',
                title:'送货地址'
            }, {
                field : 'odrStatus',
                width :'250',
                title:'订单状态',
                formatter:function(value,row,index){
                    if(value==1){
                        return "已回款";
                    }
                    if(value==2){
                        return "未回款";
                    }
                }
            } ] ]
        });
    });
</script>
</body>
</html>
