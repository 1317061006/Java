
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery
/jquery-1.4.min.js"></script>
  <title></title>
  <script type="text/javascript">
    //传递字符串格式json对象到后台（一个json对象）
    $(document).ready(function(){
      alert(1);
      $("#resolveJsonObject").click(function(){
        var userName=encodeURI($("#userName").attr("value"));
        var age = encodeURI($("#age").attr("value"));

        var user={userName:userName,age:age};
        //JSON.stringify() 方法可以将任意的 JavaScript 值序列化成 JSON 字符串
        var aMenu = encodeURI(JSON.stringify(user));

        $.ajax({
          url:"/none/resolveJsonObject",
          data:"orderJson="+aMenu,
          success:function(data){
            console.log(data+"true 已经成功传递");
          },
          error:function(error){alert("传递失败"+error)}
        });
      });

      //传递json数组到后台
      $("#resolveJsonArray").click(function(){
        var userName=encodeURI($("#userName").attr("value"));
        var age=encodeURI($("#age").attr("value"));

        //数组开始
        var user1={userName:userName,age:age};
        var allMenu={
          "menu":[ ]
        };
        allMenu.menu.push(user1);//添加到数组
        var allMenu1 = encodeURI(JSON.stringify(allMenu));

        $.ajax({
          //JSON数组
          url:"/none/resolveJsonArray",
          data:"orderJson="+allMenu1,
          success: function (data) {
            console.log(data+"true 已经成功传递");
          },
          error: function (error) {
            console.log(error)
          }
        });
      });


      //接受后台的JSON在前台解析
      $("#resolveJson").click(function () {

        $.ajax({
          //解析从后台返回的json数据
          url:"/none/resolveJson" ,
          type:"post",
          success:function(data){
            var arr=JSON.parse(data);
            alert(arr.length);
            for(var m = 0;m<arr.length;m++){
              alert(arr[m].user.userName);
            }
          }
        });
      });

    })
  </script>
</head>
<body>
<h1>json添加用户</h1>

姓名：<input id="userName" type="text" name="userName">
年龄:<input id="age" type="text" name="age"><br>
<input type="button" id="resolveJsonObject" value="json对象">
<input type="button" id="resolveJsonArray" value="json数组">
<input type="button" id="resolveJson" value="前端解析json字符串">
</body>
</html>
