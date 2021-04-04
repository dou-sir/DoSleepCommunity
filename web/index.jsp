
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page
        import="jit.dyy.dosleep.dao.PostDAO,jit.dyy.dosleep.bean.Post"%>
<%@ page import="java.util.*"%>
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
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" charset="utf-8">
        $(function(){
            $("#navlist li").click(function() {
                $(this).siblings('li').removeClass('nav_listSelected');  // 删除其他兄弟元素的样式
                $(this).addClass('nav_listSelected');                            // 添加当前元素的样式
            });
        });
        function validate() {
            var post_content = document.getElementById("post_content");

            if (post_content.value == "") {
                alert("写点啥吧！");
                post_content.focus();
                return false;
            }
            return true;
        }
    </script>
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
            <ul class="nav_list" id="navlist">
                <li class="nav_listSelected"><a href="index.jsp">主页</a></li>
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
            <form action="AddPostServlet" method="post" onsubmit="return validate();">
                <div class="div_write">

                    <textarea class="in_post" placeholder="分享自己的心情..."
                              name="post_content" id="post_content"></textarea>
                    <div class="div_submit">
                        <button name="submit" type="submit">发布</button>
                    </div>
                </div>

            </form>

            <div>
                <jsp:include page='${"PostServlet"}'>
                    <jsp:param value="pageList" name="type"/>
                    <jsp:param value="${param.pageNo }" name="pageNo"/>
                </jsp:include>
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
