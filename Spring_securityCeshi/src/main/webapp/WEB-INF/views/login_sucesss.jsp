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
<body>
Hello <sec:authentication property="principal.username" var="loginId" scope="request"/>
<sec:authorize access="hasRole('ROLE_ADMIN') and principal.username == 'admin'  ">
  <p>欢迎光临 我的主人  </p>
</sec:authorize>

<spring:out value="${loginId}"/>
<%--<sec:authorize url="/admin/**">&lt;%&ndash;并没有这个东西&ndash;%&gt;
<spring:url value="/admin" var="admin_url"/>
  <br /><a href="${admin_url}">Admin</a>
</sec:authorize>--%>

恭喜你成功来到了这里 然而并没有奖
<a href="/login_sucesss2">login_sucesss2.jsp</a>
</body>
</html>
