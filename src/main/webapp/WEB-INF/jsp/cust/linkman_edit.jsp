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
    <%@include file="/common/head.jsp"%>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 编辑联系人</div>

<form method="post">
    <div class="button_bar">
        <button class="common_button" onclick="help('');">帮助</button>
        <button class="common_button" onclick="back();">返回</button>
        <button class="common_button" onclick="submitEdit()">保存</button>
    </div>
<table class="query_form_table" id="linkman">
    <tr>
        <th>姓名</th>
        <td><input readonly name="lkmName" id="lkmName"  size="20" /><span class="red_star">*</span></td>
        <th>性别</th>
        <td>
            <input type="radio" name="lkmSex"  value="男" checked />男
            <input type="radio" name="lkmSex"  value="女" />女
        </td>
    </tr>
    <tr>
        <th>职位</th>
        <td><input name="lkmPostion" id="lkmPostion"  size="20" /><span class="red_star">*</span></td>
        <th>办公电话</th>
        <td><input name="lkmTel" id="lkmTel"  size="20" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>手机</th>
        <td><input name="lkmMobile" id="lkmMobile" size="20" /></td>
        <th>备注</th>
        <td><input name="lkmMemo" id="lkmMemo" size="20" /></td>
    </tr>
</table>

</form>

<%
    String lkmId = request.getParameter("lkmId");
%>
<script type="text/javascript" >
    //获取单个
    var lkmId = <%=lkmId%>;

    $('#linkman').form('load','linkman/load?lkmId='+lkmId);

    function submitEdit(){
        $.ajax({
            //参数个数要多注意
            type:"POST",//提交方式
            dataType:"json",//服务器返回的数据类型
            data:{
                lkmId:lkmId,
                lkmName:$("#lkmName").val(),
                lkmSex:$("input[name='lkmSex']").val(),
                lkmPostion:$("#lkmPostion").val(),
                lkmTel:$("#lkmTel").val(),
                lkmMobile:$("#lkmMobile").val(),
                lkmMemo:$("#lkmMemo").val(),
            },
            url:"linkman/edit",
            success:function (result) {
                console.log(result);//打印服务端返回的数据
                if(result.code == 0){
                    alert("修改成功");
                };
            },
            error:function(){
                //alert("异常异常");
                parent.removeTab();
            }
        });
    }
</script>
</body>
</html>
