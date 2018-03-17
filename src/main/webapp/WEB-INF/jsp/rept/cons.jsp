<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/17/017
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <%@include file="/common/head.jsp"%>
</head>
<script type="text/javascript" >
    $(function() {
        $('#gc').datagrid( {
            pagination : true,
            pageList : [ 2, 4, 6, 8 ],
            pageSize : 6,
            idFiled : 'custNo',
            fitColumns:true,
            singleSelect : true,
            url : 'customer/listDj',
            columns : [ [ {
                field : 'custLevel',
                width :'350',
                title:'客户级别',
                formatter:function(value,row,index){
                    if(value==1){
                        return "普通客户";
                    }
                    if(value==2){
                        return "重点开发客户";
                    }
                    if(value==3){
                        return "大客户";
                    }
                    if(value==4){
                        return "合作伙伴";
                    }
                    if(value==5){
                        return "战略合作伙伴";
                    }
                }
            }, {
                field : 'custSatisfy',
                width :'250',
                title:'数量'
            } ]]
        });
    });
</script>
<body>

<div class="page_title">客户构成分析</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="reload();">查询</button>
</div>
<table class="query_form_table">
    <tr>
        <th>报表方式</th>
        <td>
            <select>
                <option>按等级</option>
                <option>按信用度</option>
                <option>按满意度</option>
            </select>
        </td>

        <th>&nbsp;</th>
        <td>
            &nbsp;
        </td>
    </tr>
</table>
<br />
<table class="data_list_table" id="gc">
</table>
</body>

</html>