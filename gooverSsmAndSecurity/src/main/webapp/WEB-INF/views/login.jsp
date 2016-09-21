<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/8/4
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>login</title>
</head>
<body>
<h2>Sign in to Spitter</h2>
<p>if you been using Spitter from your phone then that's amazing ...we dont support IM yet</p>
<spring:url var="authUrl" value="/test/login.do"/>
<form method="post" class="signin" action="${authUrl}">

  <fieldset>
    <table cellpadding="0">
      <tr>
        <th><label for="username_or_email">Username or Email</label> </th><%--用户名输入域--%>
        <td><input id="username_or_email" name="j_username" type="text" /></td>
      </tr>
      <tr>
        <th><label for="password">Password</label> </th><%--密码输入域--%>
        <td><input id="password" name="j_password" type="password" />
          <small><a href="/account/resend_password">
            Forgot?
          </a> </small></td>
      </tr>
      <tr>
        <th></th><%--REMEMBER ME复选框--%>
        <td><input id="remember_me" name="_spring_security_remember_me" type="checkbox" />
          <label for="remember_me" class="inline">Remember me</label>
        </td>
      </tr>

      <tr>
        <th></th>
        <td><input name="commit" type="submit" value="Sign in" /></td>
      </tr>
    </table>

  </fieldset>

</form>

<script type="application/javascript">document.getElementById('username_or_email').focus()</script>
</body>
</html>
