<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 10:32
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

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>

    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="to('relay.jsp');">暂缓流失</button>
    <button class="common_button" onclick="actEdit()">保存</button>
</div>
<table class="query_form_table" id="lost">
    <tr>
        <th>编号</th>
        <td>${sessionScope.lost.lstId}</td>
        <th>客户</th>
        <td>${sessionScope.lost.lstCustName}</td>
    </tr>
    <tr>
        <th>客户经理</th>
        <td>
            ${sessionScope.lost.lstCustManagerName}</td>
        <th>上次下单时间</th>
        <td>
            ${sessionScope.lost.lstLastOrderDate}</td>
    </tr>
    <tr>
        <th>暂缓措施</th>
        <td colspan="3">
            ${sessionScope.lost.lstDelay}
        </td>
    </tr>
    <tr>
        <th>流失原因</th>
        <td colspan="3">
            <textarea rows="6" cols="50" id="a"></textarea><span class="red_star">*</span></td>
    </tr>
</table>
<br />

<script type="text/javascript" >
    function actEdit(){
        var v = $("#a").val();
        var s = ${sessionScope.lost.lstStatus};
        alert(s);
        $.ajax({
            //参数个数要多注意
            type:"POST",//提交方式
            dataType:"json",//服务器返回的数据类型
            data:{
                lstId:${sessionScope.lost.lstId},
                lstReason:v,
                lstStatus:s
            },
            url:"lost/edit",
            success:function (result) {
                if(result.code == 0){
                    alert("修改成功");
                    parent.removeTab();
                    parent.refresh();
                }
            },
            error:function(){
                alert("异常异常");
            }
        });
    }
</script>
</body>
</html>