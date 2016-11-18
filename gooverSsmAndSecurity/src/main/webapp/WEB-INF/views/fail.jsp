<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/9/9
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="javascript" src="/resources/jquery-3.1.0.js"/>
  <script type="text/javascript">
    $(document).ready(function(){
      $('button').click(function(){
        $("#ceshi").load("http://www.tutorialspoint.com/json/data.json",function(responseXML,statusTxt,xhr){
          if(statusTxt=="success")
          alert("外部加载成功");
          if(statusTxt =="error")
          alert("ERROR:"+xhr.status+":"+xhr.statusTxt);
        });
       document.getElementById("Test").innerHTML="fail Test测试";
      });
    })
  </script>
</head>
<body>

<p id="Test">fail.....</p>
<div id="ceshi"></div>
</body>
</html>
