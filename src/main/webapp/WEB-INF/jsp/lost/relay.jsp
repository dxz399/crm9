<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 10:33
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

<div class="page_title">客户流失管理 &gt; 暂缓流失</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>

    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="to('confirm.html');">确认流失</button>
    <button class="common_button" onclick="relayEdit()">保存</button>
</div>
<table class="query_form_table">
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
        <td colspan="3" >
            <c:if test="${sessionScope.lost.lstDelay==null}">
                <input id="yy" style="width: 320px"/>
            </c:if>
            ${sessionScope.lost.lstDelay}
         </td>
    </tr>
    <tr>
        <th>追加暂缓措施</th>
        <td colspan="3">
            <textarea rows="6" cols="50" id="yy2"></textarea><span class="red_star">*</span></td>
    </tr>
</table>
<br />

<script type="text/javascript" >
    function relayEdit(){
        var v = $("#yy").val();
        var s = ${sessionScope.lost.lstStatus};
        $.ajax({
            //参数个数要多注意
            type:"POST",//提交方式
            dataType:"json",//服务器返回的数据类型
            data:{
                lstId:${sessionScope.lost.lstId},
                lstDelay:v,
                lstStatus:s
            },
            url:"lost/edit",
            success:function (result) {
                console.log(result);//打印服务端返回的数据
                if(result.resultCode == 0){
                    alert("修改成功");
                    parent.removeTab();

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
