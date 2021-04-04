package jit.dyy.dosleep.servlet;



import jit.dyy.dosleep.bean.Post;
import jit.dyy.dosleep.bean.User;
import jit.dyy.dosleep.dao.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddPostServlet() {
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
        // 添加操作

            // 从会话对象中获取当前登录用户标识
            User user = (User) request.getSession().getAttribute("SESSION_USER");
            // 封装请求数据
            Post post = new Post(user.getUser_id(),
                    request.getParameter("post_content"),null,
                    new Date());

                // 向数据库中添加
                PostDAO dao = new PostDAO();
                dao.addPost(post);


            // 操作成功，转向首页
            response.sendRedirect("index.jsp");

    }


}
