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
    <title>hello2</title>
</head>

<link rel="stylesheet" type="text/css" href="/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/resources/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/resources/demo/demo.css">
<script type="text/javascript" src="/resources/jquery.min.js"></script>
<script type="text/javascript" src="/resources/jquery.easyui.min.js"></script>
<body>
<div style="margin:20px 0;">
  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">Open</a>
  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">Close</a>
</div>
<div id="w" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save'" style="width:500px;height:200px;padding:5px;">
  <div class="easyui-layout" data-options="fit:true">
Test02  hello2

    <div data-options="region:'east',split:true" style="width:100px"></div>
    <div data-options="region:'center'" style="padding:10px;">
      Test02  hello2
<c:out value="${username}"/>
<c:out value="${test}"/>
<c:out value="${hello}"/>
<c:out value="${user.getId()}"/>

<sf:form method="get" action="${hello2}">
</sf:form>
    </div>


    <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
      <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('成功')" style="width:80px">Ok</a>
      <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('关闭')" style="width:80px">Cancel</a>
    </div>
  </div>
</div>
<hr/>
<p align="center"><a href="/test/index">Main</a> </p>


</body>
</html>
