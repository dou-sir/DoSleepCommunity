<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/error.jsp"%>

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
    <title>就寝~Dosleep</title>
    <!-- 设置网页的基链接地址 -->
    <base href="<%=basePath%>">
    <link href="css/base.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="head">
        <div class="head_area">
            <div class="head_nav">
                <ul>
                    <li><img src="images/nav_inc1.png" /><a href="index.jsp">首页</a></li>
                    <li><img src="images/nav_inc2.png" /><a href="#">关于DoSleep</a></li>
                </ul>
            </div>
            <div class="head_logo">
                <img src="images/head_logo.png" />
            </div>
            <div class="head_user">
                <%
                    if (session.getAttribute("SESSION_USER") == null) {
                %>
                <a href="login.jsp" target="_parent"><span class="type1">登录</span></a><a
                    href="register.jsp" target="_parent"><span class="type2">注册</span></a>
                <%
                } else {
                %>
                <a href="ResumeBasicinfoServlet?type=select">Hi, ${sessionScope.SESSION_USER.user_name}<%//=sessionApplicant.getApplicantEmail()%></a>&nbsp;&nbsp;
                <a href="UserLogoutServlet">退出</a>
                <%
                    }
                %>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="top_main">
        <div class="top_logo">
            <img src="images/head_logo.jpg" />
        </div>
        <div class="top_instr">专业的睡眠交流社区</div>

    </div>
    <div class="clear"></div>
</body>
</html>
