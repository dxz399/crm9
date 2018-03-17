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

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="submitAdd()">保存</button>
</div>

<form method="post" id="add">
    <table class="query_form_table">
        <tr>
            <th>姓名</th>
            <td><input id="lkmName"  name="lkmName"/><span class="red_star">*</span></td>
            <th>性别</th>
            <td>
                <input type="radio" name="lkmSex" checked value="男" />男
                <input type="radio" name="lkmSex" value="女"/>女
            </td>
        </tr>
        <tr>
            <th>职位</th>
            <td><input id="lkmPostion" name="lkmPostion"/><span class="red_star">*</span></td>
            <th>办公电话</th>
            <td><input id="lkmTel" name="lkmTel"/><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>手机</th>
            <td><input name="lkmMobile" id="lkmMobile" size="20" /></td>
            <th>备注</th>
            <td><input name="lkmMemo" id="lkmMemo" size="20" /></td>
        </tr>
    </table>
    <input type="hidden" name="lkmCustName" value="${sessionScope.lkmCustName}"/>
    <input type="hidden" name="lkmCustNo" value="${sessionScope.lkmCustNo}"/>
</form>

<script type="text/javascript">

    function submitAdd(){
        //显示进度条
        $.messager.progress();
        $('#add').form('submit',{
            url:'linkman/add',
            onSubmit:function () {
                var isValid = $(this).form('validate');
                 if(!isValid){
                    $.messager.progress('close');//如果表单无效则隐藏进度条
                }
                return isValid;//返回false终止表单提交
            },
            success:function(data){
                $.messager.progress('close');//如果表单提交成功则隐藏进度条
                parent.refreshByTitile('查看客户联系人');
                parent.removeTab();
                if(0 == data.code){
                    $.messager.alert("提示", data.message);
                }
            }
        });
    }


</script>
</body>
</html>
