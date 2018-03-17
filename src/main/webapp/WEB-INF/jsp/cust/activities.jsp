<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:12
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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户编号</th>
        <td>${requestScope.activity.custNo}</td>
        <th>客户名称</th>
        <td>${requestScope.activity.custName}</td>
    </tr>
</table>
<br />
<table class="data_list_table" id="at">

</table>

<script type="text/javascript" >
    $(function() {
        $('#at').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'atvId',
            fitColumns:true,
            singleSelect : true,
            toolbar : [ {
                iconCls : 'icon-add',
                text : '新建',
                handler : function() {
                    parent.addTab('新建交易记录','activity/toAdd?atvCustNo='+'${requestScope.activity.custNo}','icon-add',true);
                }
            }, '-', {
                iconCls : 'icon-edit',
                text : '编辑',
                handler : function() {
                    //获得被选中的行
                    var row = $('#at').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要修改的行");
                        return;
                    }
                    //获取选中的行的atvId
                    var atvId = row.atvId;
                    parent.addTab('编辑交易记录','input/cust/activities_edit?atvId='+atvId,'icon-edit',true);
                }
            }, '-', {
                iconCls : 'icon-remove',
                text : '删除',
                handler : function() {
                    //获得被选中的行
                    var row = $('#at').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要删除的行");
                        return;
                    }
                    //获取选中的行的lkmId
                    var atvId = row.atvId;
                    var url = "activity/delete?atvId=" + atvId;
                    $.messager.confirm('确认', '您确认想要删除记录吗？？', function(r) {
                        if (r) {
                            $.ajax( {
                                dataType : 'json',
                                url : url,
                                success : function(data) {
                                    if (0 == data.code) {
                                        $.messager.alert('提示', data.message);
                                        //删除成功之后 返回指定行的索引号  便于删除 行  getRowIndex
                                        var ind = $('#at').datagrid("getRowIndex");
                                        var i = ++ind;
                                        //然后根据行id  删除行
                                        $('#at').datagrid("deleteRow", i++);
                                    } else {
                                        $message.alert('警告', '删除失败，请与管理员联系');
                                    }
                                }
                            });
                        }
                    });
                }
            } ],

            url : 'activity/list?atvCustNo='+'${requestScope.activity.custNo}',
            columns : [ [ {
                field : 'atvDate',
                width :'250',
                title:'时间'
            }, {
                field : 'atvPlace',
                width :'250',
                title:'地点'
            }, {
                field : 'atvTitle',
                width :'250',
                title:'概要'
            }, {
                field : 'atvRemark',
                width :'250',
                title:'备注'
            }, {
                field : 'atvDesc',
                width :'150',
                title:'详细'
            } ] ]
        });
    });
</script>
</body>
</html>
