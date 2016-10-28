<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/9/7
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="s" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title></title>
</head>
<body>
你好

<c:out value="${hello}"/>



 <%--<c:out value="${User.getId()}"/>--%>

<c:forEach var="user" items="${User}">

    <a href="hello">。。。</a>
    <hr>
    <s:url  value="${ceshi}" var="User_url">
        <a href="${User_url}"> 测试</a>
    <s:param name="ceshi" value="${user.getUserName()}" />
    </s:url>
    <br>
    ID: <c:out value="${user.getId()}"/>
      <br>
    userAddress:<c:out value="${user.getUserAddress()}"/>
</c:forEach>

<a href="/test/hello2 ?test=
 五术山人">...</a>

<sf:form method="get" enctype="multipart/form-data" action="/test/hello2">
     <table >
         <tr>
             <td>
                <input type="text" name="test"></td>
             </td>
             <th>
                 <input type="submit" value="提交" />
             </th>
         </tr>
     </table>
</sf:form>

</body>
</html>
