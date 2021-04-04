<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="jit.dyy.dosleep.dao.PostDAO,jit.dyy.dosleep.bean.Post" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>就寝~DoSleep</title>
    <meta name="renderer" content="ie-stand">
    <link href="css/base.css" type="text/css" rel="stylesheet" />
    <link href="css/postStyle.css" type="text/css" rel="stylesheet" />
</head>
<body class="tn-page-bg" >
<div id="tn-content" >

    <c:forEach items="${pagination.pageData}" var="post"><br>
        <div class="postbox" >
            <div class="belongbox" style="background: rgba(138,243,219,0.5)">
                <img src="images/unknow_mini.png">
                <b>发布人:${post.user.getUser_name()} </b>
                <label> 时间：${post.post_time.toString()}</label>
            </div>
            <div class="postcontent" style="background: rgba(211,237,238,0.8)">
                <a href="PostServlet?type=select&id=${post.psot_id}"
                   style="font-size: 20px"> <p>${post.post_content}</p>
                    <br></a>
                </div>
            <div class="post_data " style="background: rgba(162,235,238,0.5)">
                <img src="images/clout.png"><b> ${post.post_clout} </b>
                <img src="images/notlike.png"><b> ${post.post_like} </b>
                <img src="images/comment.png"><b> ${post.post_comment} </b>
            </div>
            <div class="clear"></div>
        </div>
    </c:forEach>
    <!-- 信息分页 -->
    <div class="page01">
        <div class="page02">&nbsp;</div>
        <div class="page03"><a href="index.jsp?type=pageList&pageNo=1">首页 </a></div>
        <c:if test="${pagination.hasPreviousPage}">
            <div class="page03">
                <a href='index.jsp?type=pageList&pageNo=${pagination.pageNo-1}'>上一页 </a></div></c:if>
        <c:if test="${pagination.hasNextPage}">
            <div class="page03"><a href="index.jsp?type=pageList&pageNo=${pagination.pageNo+1}">下一页 </a></div></c:if>
        <div class="page03"><a href="index.jsp?type=pageList&pageNo=${pagination.totalPages}">尾页</a></div>
        <div class="page03">当前是第${pagination.pageNo}页，共${pagination.totalPages}页</div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
