<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    // 获得请求的绝对地址
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录~DoSleep</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/style.css">

    <script type="text/javascript">
        function validate() {
            var uname = document.getElementById("uname");
            var password = document.getElementById("password");
            if (uname.value == "") {
                alert("用户名不能为空！");
                uname.focus();
                return false;
            }
            if (password.value == "") {
                alert("密码不能为空！");
                password.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <%
        String userName = "";
        String userPwd = "";
    // 从客户端读取Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("COOKIE_USERNAME".equals(cookie.getName())) {
                    // 解密获取存储在Cookie中的UNAME
                    userName = jit.dyy.dosleep.util.CookieEncryptTool.decodeBase64(cookie.getValue());
                }
                if ("COOKIE_USERPWD".equals(cookie.getName())) {
                    // 解密获取存储在Cookie中的登录密码
                    userPwd = jit.dyy.dosleep.util.CookieEncryptTool.decodeBase64(cookie.getValue());
                }
            }
        }
    %>
    <!--背景-->
    <div class="wel" id="background-3"></div>
    <!--登录表-->
    <div class="wel" id="from">
        <div class="box le-1">
            <form action="UserLoginServlet" method="post" onsubmit="return validate();">
                <div class="flrg">
                    <h2>DOSLEEP<br>就寝</h2>
                    <label>专业的睡眠交流社区</label>
                    <div class="a"></div>
                    <div class="a">
                        <input type="text" class="in-1" placeholder="请输入用户名或手机号"
                        name="uname" id="uname" value="<%=userName%>">
                    </div>
                    <div class="a">
                        <input type="password" class="in-1" placeholder="请输入密码"
                        name="password" id="password" value="<%=userPwd%>">
<%--                        --%>
                    </div>
                    <div class="a">
                        <button type="submit" name="submit">登录</button>
                    </div>
                    <div class="a">
                        <a href="register.jsp">没有账号？去注册</a>
                    </div>
                    <div class="clear"></div>
                    <!-- 从拦截器中获取被拦截前的请求地址 -->
                    <input type="hidden" name="requestPath" value="${requestScope.requestPath }">
                </div>
            </form>
        </div>
    </div>

</body>
</html>
