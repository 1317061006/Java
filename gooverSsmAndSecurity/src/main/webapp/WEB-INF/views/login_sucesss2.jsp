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
    <title>login_sucesss2</title>
</head>

<link rel="stylesheet" type="text/css" href="/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/resources/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/resources/demo/demo.css">
<script type="text/javascript" src="/resources/jquery.min.js"></script>
<script type="text/javascript" src="/resources/jquery.easyui.min.js"></script>

<body>
<div style="margin:20px 0;">
  <p>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="topLeft();">TopLeft</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="topCenter()">TopCenter</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="topRight()">TopRight</a>
  </p>
  <p>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="centerLeft()">CenterLeft</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="center()">Center</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="centerRight()">CenterRight</a>
  </p>
  <p>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomLeft()">BottomLeft</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomCenter()">BottomCenter</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="bottomRight()">BottomRight</a>
  </p>
</div>

<script>
  function topLeft(){
    $.messager.show({
      title:'My Title',
      msg:'这里是login_sucesss2',
      showType:'show',
      style:{
        right:'',
        left:0,
        top:document.body.scrollTop+document.documentElement.scrollTop,
        bottom:''
      }
    });
  }
  function topCenter(){
    $.messager.show({
      title:'My Title',
      msg:'这里是login_sucesss2',
      showType:'slide',
      style:{
        right:'',
        top:document.body.scrollTop+document.documentElement.scrollTop,
        bottom:''
      }
    });
  }
  function topRight(){
    $.messager.show({
      title:'My Title',
      msg:'这里是login_sucesss2',
      showType:'show',
      style:{
        left:'',
        right:0,
        top:document.body.scrollTop+document.documentElement.scrollTop,
        bottom:''
      }
    });
  }
  function centerLeft(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2',
      showType:'fade',
      style:{
        left:0,
        right:'',
        bottom:''
      }
    });
  }
  function center(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2',
      showType:'fade',
      style:{
        right:'',
        bottom:''
      }
    });
  }
  function centerRight(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2',
      showType:'fade',
      style:{
        left:'',
        right:0,
        bottom:''
      }
    });
  }
  function bottomLeft(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2',
      showType:'show',
      style:{
        left:0,
        right:'',
        top:'',
        bottom:-document.body.scrollTop-document.documentElement.scrollTop
      }
    });
  }
  function bottomCenter(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2',
      showType:'slide',
      style:{
        right:'',
        top:'',
        bottom:-document.body.scrollTop-document.documentElement.scrollTop
      }
    });
  }
  function bottomRight(){
    $.messager.show({
      title:'主题',
      msg:'这里是login_sucesss2   ',
      showType:'show'
    });
  }
</script>

<hr>
<p align="center"><a href="/test/login_sucesss" >返回login_sucess1</a>
</p>
</body>
</html>
