<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/15
  Time: 10:56
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>首页</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">
</head>
<body>
<h1>index</h1>
<a href="${pageContext.request.contextPath}/permission/role/configuration">权限配置页面</a>
<button onclick="handleClick()">zzz</button>
<script type="application/javascript">
  function handleClick() {
    axios({
      method: 'get',
      url: '/permission/role/configuration/json',
      // headers: {'X-Requested-With': 'XMLHttpRequest'}
    });
  }
</script>
</body>
</html>
