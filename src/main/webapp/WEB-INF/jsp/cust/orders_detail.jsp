<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
</div>

<table class="query_form_table" height="59">
    <tr>
        <th>订单编号</th>
        <td>${sessionScope.orders.odrId}</td>
        <th>日期</th>
        <td>${sessionScope.orders.odrDate}</td>
    </tr>
    <tr>
        <th height="28">送货地址</th>
        <td>${sessionScope.orders.odrAddr}</td>
        <th height="28">总金额（元）</th>
        <td>55200</td>
    </tr>
    <tr>
        <th height="28">状态</th>
        <td><c:if test="${sessionScope.orders.odrStatus==1 }">
                已回款
            </c:if>
            <c:if test="${sessionScope.orders.odrStatus==2 }">
                未回款
            </c:if>
        </td>
        <th height="28">&nbsp;</th>
        <td>&nbsp;</td>
    </tr>
</table>
<br />

<table class="data_list_table" id="line">
</table>
<script type="text/javascript" >
    $(function() {
        $('#line').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'oddId',
            fitColumns:true,
            singleSelect : true,
            url : 'ordersLine/list?ordersId='+${requestScope.ordersId},
            columns : [ [ {
                field : 'oddProdId',
                width :'250',
                title:'商品'
            }, {
                field : 'oddCount',
                width :'250',
                title:'数量'
            }, {
                field : 'oddUnit',
                width :'250',
                title:'单位'
            }, {
                field : 'oddPrice',
                width :'250',
                title:'单价(元)'
            }] ]
        });
    });
</script>
</body>
</html>