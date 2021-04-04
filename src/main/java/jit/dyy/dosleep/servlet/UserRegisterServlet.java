package jit.dyy.dosleep.servlet;

import jit.dyy.dosleep.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserRegisterServlet() {
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

        // 1.获取请求参数
        String type = request.getParameter("type");
        String name = request.getParameter("uname");
        String tel = request.getParameter("tel");
//todo 完善验证信息
        // 2.判断是否是使用Ajax请求进行name唯一性验证
        if("unameAjaxValidate".equals(type)){
            UserDAO dao = new UserDAO();
            boolean flag = dao.isExistUname(name);
            if(flag)
                out.print("用户名已被注册！");
            else
                out.print("用户名可以使用！");
        }else{
            String password = request.getParameter("password");
            String verifyCode = request.getParameter("verifyCode");
            // 判断验证码是否正确
            String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
            if(!sessionValidateCode.equals(verifyCode)){
                out.print("<script type='text/javascript'>");
                out.print("alert('请正确输入验证码！');");
                out.print("window.location='register.jsp';");
                out.print("</script>");
            }else{
                // 判断用户名是否已被注册
                UserDAO dao = new UserDAO();
                boolean flag = dao.isExistUname(name);
                if(flag){
                    // 用户名已注册,进行错误提示
                    out.print("<script type='text/javascript'>");
                    out.print("alert('用户名已被注册，请重新输入！');");
                    out.print("window.location='register.jsp';");
                    out.print("</script>");
                }else{
                    // 用户名未被注册，保存注册用户信息
                    dao.register(name,password,tel);
                    // 注册成功，重定向到登录页面
                    response.sendRedirect("login.jsp");
                }
            }
        }
    }

}
