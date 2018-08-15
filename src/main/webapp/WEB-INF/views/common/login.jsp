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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">
</head>
<body>
<div id="app">
    <div style="width: 30%;margin-left: 35%;margin-top: 200px">
        <el-form ref="loginForm" :model="loginForm" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</div>
<script type="text/javascript">
    let formData;
    new Vue({
        el: "#app",
        data: {
            loginForm: {
                username: "",
                password: "",
            },
            hello: "hello"
        },
        methods: {
            login() {
                axios.post('/login', this.loginForm)
                    .then(function (response) {
                        console.log("to index");
                        location.href = '/user/index';
                    });
            }
        },
        mounted() {
            formData = this.loginForm;
        }
    });
</script>
</body>
</html>
