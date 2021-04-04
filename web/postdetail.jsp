
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page
        import="jit.dyy.dosleep.dao.PostDAO,jit.dyy.dosleep.bean.Post"%>
<%@ page import="java.util.*"%>
<%@ page import="jit.dyy.dosleep.bean.Comment" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <img src="images/unknow_mini.png"  >
            </div>
            <div class="nav_head_name">
                <label>Hello World!</label>
            </div>
            <div class="nav_head_slogan">
                <label>HIHIHI</label>
            </div>
        </div>
        <ul class="nav_list" id="navlist">
            <li><a href="index.jsp">主页</a></li>
            <li><a>探索</a></li>
            <li><a>通知</a></li>
            <li><a>私信</a></li>
            <li><a>我的动态</a></li>
            <li><a>我的点赞</a></li>
            <li><a>我的资料</a></li>
            <li><a>更多</a></li>
        </ul>
    </div>
    <div class="box-2">
        <%
            Post post = (Post) request.getAttribute("post");
            List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
        %>
        <div>
            <br>
            <div class="postbox" >
                <div class="belongbox" style="background: rgba(138,243,219,0.5)">
                    <img src="images/unknow_mini.png">
                    <b>发布人:${post.user.getUser_name()}</b>
                    <label> 时间：${post.post_time.toString()}</label>
                </div>
                <div class="postcontent" style="background: rgba(211,237,238,0.8)">
                    <a style="font-size: 20px"><p>${post.post_content}</p></a>
                    <br></div>
                <div class="post_data " style="background: rgba(162,235,238,0.5)">
                    <img src="images/clout.png"><b> ${post.post_clout} </b>
                    <img src="images/notlike.png"><b> ${post.post_like} </b>
                    <img src="images/comment.png"><b> ${post.post_comment} </b>
                </div>
                <div class="clear"></div>
            </div>
            <% if(commentList!=null){
                for(Comment comment:commentList){
            %>
            <div class="comment">
                <img src="images/unknow_mini.png">
                <b>用户:<%=comment.getUser().getUser_name()%></b>
                <label> 时间：<%=comment.getComment_time().toString()%> </label>
                <b>内容：<%=comment.getComment_content()%></b>
            </div>
            <%	}
            } %>

        </div>
    </div>
    <div class="box-3">
        <div>
            <input>
        </div>
    </div>
</div>
<!-- 网站公共尾部 -->
<iframe src="foot.html" width="100%" height="150" scrolling="no"
        frameborder="0"></iframe>
</body>
</html>
