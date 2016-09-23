<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2016/8/5
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
  <script type="text/javascript">

  </script>
</head>
<body>


login Test

<form action="login" method="post">
  <table>
    <tr>
      <td> 用户名</td>
      <td><input type="text" name="username"/></td>
    </tr>
    <tr>
      <td> 密码</td>
      <td><input type="password" name="password"/></td>
    <tr>
    <td>
      <img src="/captcha.jpg" width="55" height="55" id="vci"/>
    </td>
   <td>  <input type="text" name="yzm" /></td>
    </tr>
        <td>Remmber_me</td>
      <td> <input  id="remember_me" type="checkbox" name="_spring_security_remember_me"/></td>
    </tr>

    <tr>
      <td colspan="2" align="center">
        <input type="submit" value=" 登录 "/>
        <input type="reset" value=" 重置 "/>
      </td>
    </tr>
  </table>
</form>




</body>
</html>
