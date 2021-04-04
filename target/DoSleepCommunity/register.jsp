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
    <title>DoSleep~注册</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/style.css">

    <script>
        var xhr = false;
        function createXHR() {
            try {
                xhr = new XMLHttpRequest();
            } catch (e) {
                try {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e1) {
                    xhr = false;
                }
            }
            if (!xhr)
                alert("初始化XMLHttpRequest对象失败！");
        }


        function ajaxValidate(unameObj){
            createXHR();
            var url = "UserRegisterServlet";
            var content = "type=unameAjaxValidate&uname=" + unameObj.value;
            xhr.open("POST", url, true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("unameValidate").innerHTML = xhr.responseText;
                }
            };
            xhr.setRequestHeader("Content-Length",content.length);
            xhr.setRequestHeader("CONTENT-TYPE","user/x-www-form-urlencoded");
            xhr.send(content);
        }

        <!-- 注册的form表单提交前的,验证用户名,密码校验的js代码 -->
        function validate() {
            //获取uname和password
            var uname = document.getElementById("uname");
            var password = document.getElementById("password");
            var password2 = document.getElementById("password2");
            var tel = document.getElementById("tel");

            if (uname.value == "") {
                alert("用户名不能为空！");
                uname.focus();
                return false;
            }
            if (password.value == "") {
                alert("密码不能为空！");
                password.focus();
                return false;
            } else if (password.length<6 || password.length>12) {
                alert("密码长度不符合要求，请输入6-12位密码!");
                password2.focus();
                return false;
            } else if (password.value != password2.value) {
                alert("两次输入密码不一致");
                password2.focus();
                return false;
            }
            if(tel.value == "") {
                alert("手机号不能为空！");
                tel.focus();
                return false;
            }
            return true;
        }

        //验证码的更换
        function changeValidateCode() {
            document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
                + Math.random();
        }
    </script>
</head>
<body>
    <!--背景-->
    <div class="wel" id="background-3"></div>
    <!--注册表-->
    <div class="wel" id="from">

        <div class="box le-2">
            <form action="UserRegisterServlet" method="post" onsubmit="return validate();">
                <div class="flrg">
                    <h2>DOSLEEP<br>就寝</h2>
                    <label>专业的睡眠交流社区</label>
                    <h3>注册账号</h3>
                    <div class="a">
                        <label>用户名</label>
                        <label style="color: red" id="unameValidate"></label><br>
                        <input type="text" class="in-1" placeholder="您的用户名"
                               name="uname" id="uname" onblur="ajaxValidate(this)">
                    </div>
                    <div class="a">
                        <label>密码</label><br>
                        <input type="password" class="in-1" name="password" id="password" placeholder="输入密码">
                    </div>
                    <div class="a">
                        <input type="password" class="in-1" name="password2" id="password2" placeholder="再次确认密码">
                    </div>
                    <div class="a">
                        <label>手机号</label><br>
                        <input type="text" class="in-1" name="tel" id="tel" placeholder="输入手机号码">
                    </div>
                    <div class="a"><!-- 验证码相关的东西 -->
                        <input type="text" class="in-2" name="verifyCode" placeholder="输入验证码">
                        <span>
							<img src="ValidateCodeServlet"
                                 id="validateCode" title="点击换一换" onclick="changeValidateCode()">
							<a href="javascript:changeValidateCode();">看不清?</a>
						</span>

                    </div>
                    <div class="a">
                        <button name="submit" type="submit">注册</button>
                    </div>
                    <div class="a">
                        <a href="login.jsp">已有账号。去登录</a>
                    </div>
                    <div class="clear"></div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
