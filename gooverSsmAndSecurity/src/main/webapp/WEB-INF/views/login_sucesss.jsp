<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/8/5
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>login_sucesss</title>
</head>
<link rel="stylesheet" type="text/css" href="/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/resources/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/resources/demo/demo.css">
<script type="text/javascript" src="/resources/jquery.min.js"></script>
<script type="text/javascript" src="/resources/jquery.easyui.min.js"></script>
<body>
<div style="margin:20px 0 10px 0;">
  <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
  <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
</div>
  <p style="font-size:14px">点击OPEN打开 Close关闭 已经成功访问到本页面</p>
<div id="p" class="easyui-panel" title="Basic Panel" style="width:700px;height:200px;padding:10px;">
 <ul>
 <li> Hello  <sec:authentication property="principal.username" var="loginID" scope="request"/>
 <sec:authentication property="details.SessionId" var="detailsID" scope="request"/>
   <spring:out value="${loginID}"/>
   session ID:<spring:out value="${detailsID}"/>
</li>

 <%--<sec:authentication property="principal.isRememberMe()" var="remember" scope="request"/>--%>
<li>  具有权限或打开某个功能时才会显示<sec:authorize access="hasRole('ROLE_ADMIN') and principal.username == 'admin'  ">
  <p>欢迎光临 我的主人 </p>
</sec:authorize>

<sec:authorize access="isRememberMe() and  permitAll">
  <p>您启动了 ....RemeberME</p>
</sec:authorize>
 </li>



<%--<spring:out value="${IP}"/>--%>
<hr />
   <li>
恭喜你成功来到了这里 然而并没有奖
<a href="/test/login_sucesss2">login_sucesss2.jsp</a>
<br>
   </li>
<li>测试页面：
<sec:authorize url="/test/**">
  <spring:url var="test_url" value="/test/login_sucesss3"/>
  <br > <a href="${test_url}">login_sucess3 </a>
</sec:authorize>
 </li>
 <li><a href="/test/index">Main</a> </li>
  </ul>
    </div>
</body>
</html>
