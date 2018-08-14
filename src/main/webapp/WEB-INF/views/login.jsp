<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/13
  Time: 11:14
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<div style="margin: auto auto">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">用户名：</label><input type="text" name="username" id="username"><br>
        <label for="password">密 码：</label><input type="password" name="password" id="password"><br>
        <label for="submit">登录</label><input type="submit" id="submit">
    </form>
</div>
</body>
</html>
