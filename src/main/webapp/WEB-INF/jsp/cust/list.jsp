<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <%@include file="/common/head.jsp" %>

</head>
<body>

<div class="page_title">客户信息管理</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="reload();">查询</button>
</div>
<table class="query_form_table" >
    <tr>
        <th>客户编号</th>
        <td><input /></td>
        <th>名称</th>
        <td><input /></td>
        <th>地区</th>
        <td>
            <select>
                <option>全部</option>
                <option>北京</option>
                <option>华北</option>
                <option>中南</option>
                <option>东北</option>
                <option>西部</option>
            </select>
        </td>
    </tr>
    <tr>
        <th>客户经理</th>
        <td><input /></td>
        <th>客户等级</th>
        <td>
            <select>
                <option>全部</option>
                <option>战略合作伙伴</option>
                <option>合作伙伴</option>
                <option>大客户</option>
                <option>普通客户</option>
            </select>
        </td>
        <th>　</th>
        <td>　</td>
    </tr>
</table>
<br />
<table class="data_list_table" id="cm">
</table>
<script type="text/javascript"  src="js/listCustomer.js">
</script>
</body>
</html>
