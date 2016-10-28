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
Hello  <sec:authentication property="principal.username" var="loginID" scope="request"/>
<sec:authentication property="details.SessionId" var="detailsID" scope="request"/>

 <%--<sec:authentication property="principal.isRememberMe()" var="remember" scope="request"/>--%>
<sec:authorize access="hasRole('ROLE_ADMIN') and principal.username == 'admin'  ">
  <p>欢迎光临 我的主人 </p>
</sec:authorize>

<sec:authorize access="isRememberMe() and  permitAll">
  <p>您启动了 ....RemeberME</p>
</sec:authorize>
 



<spring:out value="${loginID}"/>
session ID:<spring:out value="${detailsID}"/>
<%--<spring:out value="${IP}"/>--%>
<hr />
恭喜你成功来到了这里 然而并没有奖
<a href="/test/login_sucesss2">login_sucesss2.jsp</a>
<br>
达到要求（才会显示）：
<sec:authorize url="/test/**">
  <spring:url var="test_url" value="/test/login_sucesss3"/>
  <br > <a href="${test_url}">login_sucess3 </a>
</sec:authorize>

</body>
</html>
