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
    <title>Hello</title>
    <link rel="stylesheet" type="text/css" href="/resources/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/resources/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/resources/demo/demo.css">
    <script type="text/javascript" src="/resources/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/jquery.easyui.min.js"></script>
</head>
<body>

<div style="margin:20px 0 10px 0;">
    <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
    <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
</div>
你好

<c:out value="${hello}"/>


<div id="p" class="easyui-panel" title="Basic Panel" style="width:700px;height:200px;padding:10px;">
 <%--<c:out value="${User.getId()}"/>--%>
<ul>
<li><c:forEach var="user" items="${User}">

    <a href="hello">。。。</a>
</li>

  <li>
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
    </li>
    </ul>
</div>
</body>
</html>
