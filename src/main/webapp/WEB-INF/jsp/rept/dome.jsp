<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/17/017
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
    <script type="text/javascript" src="/js/echarts.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart=echarts.init(document.getElementById("main"));
    myChart.setOption({
        title:{
            text:'客户构成分析'
        },
        legend:{
            data:['客户数量']
        },
        xAxis:{
            data:[]
    },
    yAxis:{
    },
    series:[
        {
            name:'客户数量',
            type:'bar',
            data:[]
    },
    ]
    });

    $.post("cust/listDj",
             {},
          function(data){
              myChart.setOption({
                  xAxis:{
                      data:data.dj
                  },
                           series:[
                                  {
                                      name:'数量',
                                      data:data.xl
                             },
                            ]
                         });
                      },
             "json"
             )




</script>

</body>
</html>
