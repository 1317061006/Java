<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/9/23
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错</title>
</head>

<script type="application/javascript">
  function load(){
   alert("出错信息为： invalid-session-url 指定使用已经超时的 sessionId 进行请求需要重定向的页面");
  }
</script>
<body onload="load()">
 <a href="/test/login.do">访问到此页面进行登录</a>

</body>
</html>
