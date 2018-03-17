<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="actAdd()">保存</button>
</div>
<form method="post" id="add">

    <table class="query_form_table">
        <tr>
            <th>时间</th>
            <td><input  id="atvDate" size="20" /><span class="red_star">*</span></td>
            <th>地点</th>
            <td>
                <input  name="atvPlace"  size="20" /><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>概要</th>
            <td><input name="atvTitle" size="20" /><span class="red_star">*</span></td>
            <th>备注</th>
            <td><input  name="atvRemark" size="20" /></td>
        </tr>
        <tr>
            <th>详细信息</th>
            <td colspan="3">
                <textarea cols="50" rows="6"  name="atvDesc"></textarea>
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript">

    function actAdd(){
        //显示进度条
        $.messager.progress();
        $('#add').form('submit',{
            url:'activity/add?atvCustNo='+'${requestScope.atvCustNo}',
            queryParams:{
                atvDate:$("#atvDate").val(),
                atvPlace:$("input[name='atvPlace']").val(),
                atvTitle:$("input[name='atvTitle']").val(),
                atvRemark:$("input[name='atvRemark']").val(),
                atvDesc:$("input[name='atvDesc']").val()
            },
            onSubmit:function () {
                var isValid = $(this).form('validate');
                if(!isValid){
                    $.messager.progress('close');//如果表单无效则隐藏进度条
                }
                return isValid;//返回false终止表单提交
            },
            success:function(data){
                $.messager.progress('close');//如果表单提交成功则隐藏进度条
                if(data.code==0){
                    $.messager.alert("提示", data.message);
                    parent.removeTab();
                    parent.refresh();
                }
            }
        });
    }
</script>
</body>
</html>