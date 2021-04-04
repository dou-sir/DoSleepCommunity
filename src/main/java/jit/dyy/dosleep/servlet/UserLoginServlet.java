package jit.dyy.dosleep.servlet;

import jit.dyy.dosleep.bean.User;
import jit.dyy.dosleep.constant.CommonConstant;
import jit.dyy.dosleep.dao.UserDAO;
import jit.dyy.dosleep.util.CookieEncryptTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录功能实现
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取请求参数
        String name = request.getParameter("uname");
        String password = request.getParameter("password");
//        String rememberMe = request.getParameter("rememberMe");
        String requestPath = request.getParameter("requestPath");
        // 登录验证
        UserDAO dao = new UserDAO();
        int user_id = dao.loginByName(name,password);
        if (user_id != 0) {
            // 用户登录成功,将求职者信息存入session
            User user = new User(user_id, name, password);
            request.getSession().setAttribute(CommonConstant.SESSION_USER, user);
            // 通过Cookie记住邮箱和密码
            rememberMe( name, password, request, response);
//            rememberMe(rememberMe, name, password, request, response);
            //判断是否已存在请求路径
            if(!"".equals(requestPath) && null!=requestPath){
                response.sendRedirect(requestPath);
            }else{
                response.sendRedirect("index.jsp");
            }
        } else {
            // 用户登录信息错误，进行错误提示
            out.print("<script type='text/javascript'>");
            out.print("alert('用户名或密码错误，请重新输入！');");
            out.print("window.location='login.jsp';");
            out.print("</script>");
        }
    }

    /**
     * 记住当前登录用户
     */
    private void rememberMe( String name, String password,     //String rememberMe,
                            HttpServletRequest request, HttpServletResponse response) {
        // 判断是否需要通过Cookie记住邮箱和密码
//        if ("true".equals(rememberMe)) {
        if (true) {
            // 记住邮箱及密码
            Cookie cookie = new Cookie("COOKIE_USERNAME",
                    CookieEncryptTool.encodeBase64(name));
            cookie.setPath("/");
            cookie.setMaxAge(365 * 24 * 3600);
            response.addCookie(cookie);

            cookie = new Cookie("COOKIE_USERPWD",
                    CookieEncryptTool.encodeBase64(password));
            cookie.setPath("/");
            cookie.setMaxAge(365 * 24 * 3600);
            response.addCookie(cookie);
        } else {
            // 将邮箱及密码Cookie清空
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("COOKIE_USERNAME".equals(cookie.getName())
                            || "COOKIE_USERPWD".equals(cookie.getName())) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        }
    }

}
