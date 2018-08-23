<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemeth" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>your site name-<sitemeth:title/></title>
  <c:set var="BasePath" value="${pageContext.request.contextPath}"/>

  <%-- 加入标题栏的小图标 --%>
  <link href="${BasePath}/static/images/cloud_disk.ico" type="image/x-icon" rel="shortcut icon"/>

  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">

  <sitemeth:head/>
  <script type="application/javascript">
    const request = axios.create({
      timeout: 30000,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'X-Requested-With': 'XMLHttpRequest'
      }
    });
  </script>
</head>
<body>
  <sitemeth:body/>
</body>
</html>