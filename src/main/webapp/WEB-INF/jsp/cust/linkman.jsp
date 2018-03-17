<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:15
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

<div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
<div class="button_bar" id="wu-dialog">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="to('linkman_add.html');">新建</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户编号</th>
        <td>${sessionScope.cust.custNo}</td>
        <th>客户名称</th>
        <td>${sessionScope.cust.custName}</td>
    </tr>
</table>
<br />
<table class="data_list_table" id="lm">


</table>

<script type="text/javascript" >
    $(function() {
        $('#lm').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'lkmId',
            fitColumns:true,
            singleSelect : true,
            toolbar : [ {
                iconCls : 'icon-add',
                text : '新增',
                handler : function() {
                    parent.addTab('新增联系人信息','linkman/toAdd?lkmCustNo='+'${sessionScope.cust.custNo}'+'&&lkmCustName='+'${sessionScope.cust.custName}','icon-edit',true);
                }
            }, '-', {
                iconCls : 'icon-edit',
                text : '编辑',
                handler : function() {
                    //获得被选中的行
                    var row = $('#lm').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要修改的行");
                        return;
                    }
                    //获取选中的行的lkmId
                    var lkmId = row.lkmId;
                    parent.addTab('编辑联系人信息','input/cust/linkman_edit?lkmId='+lkmId,'icon-edit',true);
                }
            }, '-', {
                iconCls : 'icon-remove',
                text : '删除',
                handler : function() {
                    //获得被选中的行
                    var row = $('#lm').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要删除的行");
                        return;
                    }
                    //获取选中的行的lkmId
                    var lkmId = row.lkmId;
                    var url = "linkman/delete?lkmId=" + lkmId;
                    $.messager.confirm('确认', '您确认想要删除记录吗？？', function(r) {
                        if (r) {
                            $.ajax( {
                                dataType : 'json',
                                url : url,
                                success : function(data) {
                                    if (0 == data.code) {
                                        $.messager.alert('提示', data.message);
                                        //删除成功之后 返回指定行的索引号  便于删除 行  getRowIndex
                                        var ind = $('#lm').datagrid("getRowIndex");
                                        //然后根据行id  删除行
                                        $('#lm').datagrid("deleteRow", ind);
                                    } else {
                                        $message.alert('警告', '删除失败，请与管理员联系');
                                    }
                                }
                            });
                        }
                    });
                }
            } ],

            url : 'linkman/list?lkmCustNo='+'${sessionScope.cust.custNo}',
            columns : [ [ {
                field : 'lkmName',
                width :'250',
                title:'姓名'
            }, {
                field : 'lkmSex',
                width :'250',
                title:'性别'
            }, {
                field : 'lkmPostion',
                width :'250',
                title:'职位'
            }, {
                field : 'lkmTel',
                width :'250',
                title:'办公电话'
            }, {
                field : 'lkmMobile',
                width :'150',
                title:'手机'
            }, {
                field : 'lkmMemo',
                width :'150',
                title:'备注'
            } ] ]
        });
    });
</script>

</body>
</html>