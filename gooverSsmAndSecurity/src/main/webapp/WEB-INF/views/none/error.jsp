<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/9/29
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


<html>
<head>
    <title>报错</title>
</head>
<script type="text/javascript">
  function load(){
    alert("全局管理报错 在控制台输出原因");
    console.log("${message}");
  }
</script>
<body onload="load()">
<%--全局管理异常报错的地方 <p> <strong>${message}</strong></p>--%>
      <p align="center"> <a href="/test/index">index</a> </p>
</body>
</html>
