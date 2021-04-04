package jit.dyy.dosleep.servlet;

import jit.dyy.dosleep.bean.User;
import jit.dyy.dosleep.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet {
    private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
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
        // 获取请求操作类型
        String type = request.getParameter("type");
        // 用户添加操作
        if ("add".equals(type)) {
            // 从会话对象中获取当前登录用户标识
            User user = (User) request.getSession().getAttribute("SESSION_USER");
            // 封装请求数据
            User basicinfo = this.requestDataObj(request, user.getUser_id());
            response.sendRedirect("ResumeBasicinfoServlet?type=select");
        }else if("select".equals(type)){ // 用户查询操作
            // 从会话对象中获取当前登录用户标识
            User user = (User) request.getSession().getAttribute("SESSION_USER");
            // 根据用户标识查询用户基本信息
            UserDAO dao = new UserDAO();
            User basicinfo = dao.findUserByID(user.getUser_id());
            // 将用户基本信息存入request对象进行请求转发
            request.setAttribute("userinfo", basicinfo);
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }else if("updateSelect".equals(type)){ // 用户更新前的查询
            // 从会话对象中获取当前登录用户标识
            User user = (User) request.getSession().getAttribute("SESSION_USER");            // 根据用户标识查询用户基本信息
            UserDAO dao = new UserDAO();
            User basicinfo = dao.findUserByID(user.getUser_id());
            // 将用户基本信息存入request对象进行请求转发
            request.setAttribute("userinfo", basicinfo);
            request.getRequestDispatcher("userinfoUpdate.jsp").forward(request, response);
        }else if("update".equals(type)){
            User user = (User) request.getSession().getAttribute("SESSION_USER");
            // 封装请求数据
            User basicinfo = this.requestDataObj(request,user.getUser_id());
            basicinfo.setUser_id(user.getUser_id());
            // 更新用户信息
            try{
                UserDAO dao = new UserDAO();
                dao.updateUser(basicinfo);
            }catch(Exception e){
                System.out.println("user更新失败");
            }


            request.setAttribute("userinfo", basicinfo);
            request.getRequestDispatcher("userinfoUpdate.jsp").forward(request, response);
        }
    }

    /**
     * 将请求的用户数据封装成一个对象
     *
     * @param request
     * @return
     */
    private User requestDataObj(HttpServletRequest request,int userID) {
        User basicinfo = null;
        // 获得请求数据
        String user_name = request.getParameter("user_name");
        String user_pwd = request.getParameter("user_pwd");
        String user_tel = request.getParameter("user_tel");
        String birthday = request.getParameter("birthday");
        String user_img = request.getParameter("user_img");
        String user_slogan = request.getParameter("user_slogan");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = null;
        try {
            birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            birthdayDate = null;
        }
        // 将请求数据封装成一个用户基本信息对象
        basicinfo = new User(userID,user_name,user_pwd,user_tel,birthdayDate,user_img,user_slogan);
        return basicinfo;
    }
}
