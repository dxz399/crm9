<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:13
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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
<form method="post">
    <div class="button_bar">
        <button class="common_button" onclick="help('');">帮助</button>
        <button class="common_button" onclick="back();">返回</button>
        <button class="common_button" onclick="actEdit()">保存</button>
    </div>
    <table class="query_form_table" id="activity">
        <tr>
            <th>时间</th>
            <td><input id="atvDate" name="atvDate" size="20" /><span class="red_star">*</span></td>
            <th>地点</th>
            <td>
                <input name="atvPlace"   size="20" /><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>概要</th>
            <td><input name="atvTitle"  size="20" /><span class="red_star">*</span></td>
            <th>备注</th>
            <td><input name="atvRemark"   size="20" /></td>
        </tr>
        <tr>
            <th>详细信息</th>
            <td colspan="3">
                <textarea cols="50" rows="6" name="atvDesc" id="d" ></textarea>
            </td>
        </tr>
    </table>
</form>

<%
    String atvId = request.getParameter("atvId");
%>
<script type="text/javascript" >
    //获取单个
    var atvId = <%=atvId%>;
    $('#activity').form('load','activity/load?atvId='+atvId);

    function actEdit(){
        $.ajax({
            //参数个数要多注意
            type:"POST",//提交方式
            dataType:"json",//服务器返回的数据类型
            data:{
                atvId:atvId,
                atvPlace:$("input[name='atvPlace']").val(),
                atvTitle:$("input[name='atvTitle']").val(),
                atvRemark:$("input[name='atvRemark']").val(),
                atvDesc:$("#d").val()
            },
            url:"activity/edit",
            success:function (result) {
                console.log(result);//打印服务端返回的数据
                if(result.code == 0){
                    alert("修改成功");
                    parent.removeTab();
                };
            },
            error:function(){
               // alert("异常异常");
                parent.removeTab();
            }
        });
    }
</script>
</body>
</html>
