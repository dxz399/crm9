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

<div class="page_title">客户流失管理</div>
<div class="button_bar">
    <a id="listBtn2" href="#" class="common_button" >帮助</a>
    <a id="listBtn" href="#" class="common_button" >查询</a>
</div>
<table class="query_form_table">
    <tr>
        <th>客户</th>
        <td><input id="lstCustName"/></td>
        <th>客户经理</th>
        <td><input id="lstCustManagerName"/></td>
        <th>状态</th>
        <td>
            <select>
                <option>全部</option>
                <option>预警</option>
                <option>暂缓流失</option>
                <option>确认流失</option>
            </select>
        </td>
    </tr>
</table>
<br />
<table class="data_list_table" id="lost">
</table>
<script type="text/javascript" >
    $(function() {
        $('#lost').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'lstId',
            singleSelect : true,
            toolbar : [ {
                iconCls : 'icon-basket-remove',
                text : '确认流失',
                handler : function() {
                    //获得被选中的行
                    var row = $('#lost').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要确认流失的行");
                        return;
                    }
                    //获取选中的行的lstId
                    var lstId = row.lstId;
                    parent.addTab('确认流失','lost/toConfirm?lstId='+lstId,'icon-basket-remove',true);
                }
            }, '-', {
                iconCls : 'icon-basket-put',
                text : '暂缓流失',
                handler : function() {
                    //获得被选中的行
                    var row = $('#lost').datagrid("getSelected");
                    if (!row) {
                        $.messager.alert('警告', "请选择要暂缓流失的行");
                        return;
                    }
                    //获取选中的行的lstId
                    var lstId = row.lstId;
                    var lstStatus = row.lstStatus;
                    if(lstStatus=3){
                        alert("该客户已经确认流失--无法暂缓流失");
                        return false;
                    }
                    parent.addTab('暂缓流失','lost/toRelay?lstId='+lstId,'icon-basket-put',true);
                }
            } ],

            url : 'lost/list',
            columns : [ [ {
                field : 'lstId',
                width :'250',
                title:'编号'
            }, {
                field : 'lstCustName',
                width :'250',
                title:'客户名称'
            }, {
                field : 'lstLastOrderDate',
                width :'250',
                title:'上次下单时间'
            }, {
                field : 'lstLostDate',
                width :'250',
                title:'确认流失时间'
            }, {
                field : 'lstStatus',
                width :'150',
                title:'状态',
                formatter:function(value,row,index){
                    if(value==1){
                        return "预警";
                    }
                    if(value==2){
                        return "暂缓流失";
                    }
                    if(value==3){
                        return "确认流失";
                    }
                    if(value==4){
                        return "暂缓客户流失成功";
                    }
                }
            } ] ]
        });
    });
    $("#listBtn").click(function() {
        //获取查询文本框的值
        var formData = {
            lstCustName : $("#lstCustName").val()
        }
        $('#lost').datagrid( {
            //在请求远程数据的时候发送额外的参数(kh)
            queryParams : formData
        });
        //终止默认行为
        return false;
    });

    $("#listBtn2").click(function() {
        //获取查询文本框的值
        var formData = {
            lstCustManagerName : $("#lstCustManagerName").val()
        }
        $('#lost').datagrid( {
            //在请求远程数据的时候发送额外的参数(kh)
            queryParams : formData
        });
        //终止默认行为
        return false;
    });
</script>
</body>
</html>
