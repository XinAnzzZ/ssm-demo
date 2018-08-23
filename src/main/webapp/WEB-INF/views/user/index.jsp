<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/15
  Time: 10:56
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BasePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>首页</title>
</head>
<body>
<h1>index</h1>
<a href="${BasePath}/permission/role/configuration">权限配置页面</a>
<a href="${BasePath}/user/list">列表页</a>
<button onclick="handleClick()">zzz</button>
<script type="application/javascript">
  function handleClick() {
    request.get('/permission/role/configuration/json');
  }
</script>
</body>
</html>
