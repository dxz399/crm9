<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6/006
  Time: 9:14
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
<div class="page_title">客户信息管理 > 客户信息</div>
<form  method="post">


<table class="query_form_table" id="f">
    <tr>
        <th>客户编号</th>
        <td><input name="custNo" id="custNo"> </td>
        <th>名称</th>
        <td><input name="custName" id="custName"/><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>地区</th>
        <td>
            <select name="custRegion" id="custRegion">
                <option>请选择...</option>
                <option value="北京" selected>北京</option>
                <option value="华北">华北</option>
                <option value="中南">中南</option>
                <option value="东北">东北</option>
                <option value="西部">西部</option>
            </select>
            <span class="red_star">*</span></td>
        <th>客户经理</th>
        <td>
            <select name="custManagerName" id="custManagerName">
                <option>请选择...</option>
                <option value="小明"  selected>小明</option>
                <option value="旺财">旺财</option>
                <option value="球球">球球</option>
                <option value="孙小美">孙小美</option>
                <option value="周洁轮">周洁轮</option>
            </select><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>客户等级</th>
        <td>
            <select name="custLevel" id="custLevel">
                <option>请选择...</option>
                <option value="1" selected>战略合作伙伴</option>
                <option value="2">合作伙伴</option>
                <option value="3">大客户</option>
                <option value="4">重点开发客户</option>
                <option value="5">普通客户</option>
            </select><span class="red_star">*</span>
        </td>
        <th>　</th>
        <td>　</td>
    </tr>
    <tr>
        <th>客户满意度</th>
        <td>
            <select name="custSatisfy" id="custSatisfy"><option value="">未指定</option>
                <option value="5">☆☆☆☆☆</option>
                <option value="4">☆☆☆☆</option>
                <option value="3" selected="selected">☆☆☆</option>
                <option value="2">☆☆</option>
                <option value="1">☆</option></select><span class="red_star">*</span>
        </td>
        <th>客户信用度</th>
        <td>
            <select name="custCredit" id="custCredit"><option value="">未指定</option>
                <option value="5">☆☆☆☆☆</option>
                <option value="4">☆☆☆☆</option>
                <option value="3" selected="selected">☆☆☆</option>
                <option value="2">☆☆</option>
                <option value="1">☆</option></select><span class="red_star">*</span>
        </td>
    </tr>

<br />
    <tr>
        <th>地址</th>
        <td><input name="custAddr" id="custAddr" /><span class="red_star">*</span>
        </td>
        <th>邮政编码</th>
        <td><input name="custZip" id="custZip"   size="20" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>电话</th>
        <td>
            <input name="custTel" id="custTel" size="20"  /><span class="red_star">*</span></td>
        <th>传真</th>
        <td>
            <input name="custFax" id="custFax"   size="20"  /><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>网址</th>
        <td>
            <input name="custWebsite"  id="custWebsite"  size="20"  /><span class="red_star">*</span>
        </td>
        <th>　</th>
        <td>　</td>
    </tr>

<br />

    <tr>
        <th>营业执照注册号</th>
        <td><input name="custLicenceNo"  id="custLicenceNo"  size="20" /></td>
        <th>法人</th>
        <td><input name="custChieftain" id="custChieftain"   size="20" /><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>注册资金（万元）</th>
        <td>
            <input name="custBankroll" id="custBankroll" value="" size="20" /> </td>
        <th>年营业额</th>
        <td>
            <input name="custTurnover" id="custTurnover" value="" size="20" />
        </td>
    </tr>
    <tr>
        <th>开户银行</th>
        <td>
            <input name="custBank" id="custBank"  size="20" /><span class="red_star">*</span>
        </td>
        <th>银行帐号</th>
        <td><input name="custBankAccount" id="custBankAccount"  size="20" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>地税登记号</th>
        <td>
            <input name="custLocalTaxNo" id="custLocalTaxNo"  value=""  size="20" /></td>
        <th>国税登记号</th>
        <td><input name="custNationalTaxNo" id="custNationalTaxNo" value=""  size="20" /></td>
    </tr>
</table>
    <div class="button_bar">
        <button class="common_button" onclick="help('');">帮助</button>
        <button class="common_button" onclick="to('linkman.html');">联系人</button>
        <button class="common_button" onclick="to('activities.html');">交往记录</button>
        <button class="common_button" onclick="to('orders.html');">历史订单</button>

        <button class="common_button" onclick="back();">返回</button>
        <button class="common_button" onclick="submitEdit()">保存</button>
    </div>
</form>

<script type="text/javascript" >
    $('#f').form('load','customer/load?custNo='+'${sessionScope.custNo}');

    function submitEdit(){
        $.ajax({
            //参数个数要多注意
            type:"POST",//提交方式
            dataType:"json",//服务器返回的数据类型
            data:{
                custNo:'${sessionScope.custNo}',
                custName:$("#custName").val(),
                custRegion:$("#custRegion").val(),
                custManagerName:$("#custManagerName").val(),
                custLevel:$("#custLevel").val(),
                custSatisfy:$("#custSatisfy").val(),
                custCredit:$("#custCredit").val(),
                custAddr:$("#custAddr").val(),
                custZip:$("#custZip").val(),
                custTel:$("#custTel").val(),
                custFax:$("#custFax").val(),
                custWebsite:$("#custWebsite").val(),
                custLicenceNo:$("#custLicenceNo").val(),
                custChieftain:$("#custChieftain").val(),
                custBankroll:$("#custBankroll").val(),
                custTurnover:$("#custTurnover").val(),
                custBank:$("#custBank").val(),
                custBankAccount:$("#custBankAccount").val(),
                custLocalTaxNo:$("#custLocalTaxNo").val(),
                custNationalTaxNo:$("#custNationalTaxNo").val(),
            },
            url:"customer/edit",
            success:function (result) {
                if(result.code == 0){
                    alert("修改成功");

                }else{
                    $message.alert('警告', '修改失败，请与管理员联系');
                }
            },
            error:function(){
               // alert("异常异常");
                parent.removeTab();
            }
        });

    }
</script>
<p>　</p>
</body>
</html>