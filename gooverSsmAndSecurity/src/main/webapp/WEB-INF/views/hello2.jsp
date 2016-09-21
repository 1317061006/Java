<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/9/7
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="s" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


Test02  hello2

..

...
<c:out value="${username}"/>
<c:out value="${test}"/>
<c:out value="${hello}"/>
<c:out value="${user.getId()}"/>

<sf:form method="get" action="${hello2}">


</sf:form>




</body>
</html>
