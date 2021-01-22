
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>DoSleep~注册</title>
    <link rel="stylesheet" href="css/style.css">

    <script>
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
            <form action="" method="post">
                <div class="flrg">
                    <h2>DOSLEEP<br>就寝</h2>
                    <label>专业的睡眠交流社区</label>
                    <h3>注册账号</h3>
                    <div class="a">
                        <label>用户名</label><br>
                        <input type="text" class="in-1" placeholder="您的用户名">
                    </div>
                    <div class="a">
                        <label>密码</label><br>
                        <input type="password" class="in-1" placeholder="输入密码">
                    </div>
                    <div class="a">
                        <input type="password" class="in-1" placeholder="再次确认密码">
                    </div>
                    <div class="a">
                        <label>手机号</label><br>
                        <input type="text" class="in-1" placeholder="输入手机号码">
                    </div>
                    <div class="a"><!-- 验证码相关的东西 -->
                        <input type="text" class="in-2" placeholder="输入验证码">
                        <span>
							<img src="ValidateCodeServlet"
                                 id="validateCode" title="点击换一换" onclick="changeValidateCode()">
							<a href="javascript:changeValidateCode();">看不清?</a>
						</span>

                    </div>
                    <div class="a">
                        <button type="button">注册</button>
                    </div>
                    <div class="a">
                        <a href="login.jsp">已有账号。去登录</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
