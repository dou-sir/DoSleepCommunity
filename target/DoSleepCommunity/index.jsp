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
    <title>就寝DoSleep~专业的睡眠交流社区</title>
    <base href="<%=basePath%>">
    <meta name="renderer" content="ie-stand">
    <link href="css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 网站公共头文件 -->
    <jsp:include page="top.jsp"></jsp:include>
    <div class="bigbox">
        <div class="box-1">
            <div class="nav_head">
                <div class="nav_head_img">
                    <img src="images/img-unknow.png"  >
                </div>
                <div class="nav_head_name">
                    <label>Hello World!</label>
                </div>
                <div class="nav_head_slogan">
                    <label>HIHIHI</label>
                </div>
            </div>
            <ul class="nav_list">
                <li>主页</li>
                <li>探索</li>
                <li>通知</li>
                <li>私信</li>
                <li>我的动态</li>
                <li>我的点赞</li>
                <li>我的资料</li>
                <li>更多</li>
            </ul>
        </div>
        <div class="box-2">
            <div class="div_post">
                <textarea class="in_post"></textarea>
            </div>
        </div>
        <div class="box-3"></div>
    </div>
    <!-- 网站公共尾部 -->
    <iframe src="foot.html" width="100%" height="150" scrolling="no"
            frameborder="0"></iframe>
</body>
</html>
