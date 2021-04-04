package jit.dyy.dosleep.servlet;

import jit.dyy.dosleep.bean.Comment;
import jit.dyy.dosleep.bean.Post;
import jit.dyy.dosleep.bean.PostPageBean;
import jit.dyy.dosleep.dao.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PostServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 获取对动态信息处理的请求类型
        String type = request.getParameter("type");
        if ("select".equals(type)) {
            // 获取请求查询的动态id
            int postID = Integer.parseInt(request.getParameter("id"));
            // 根据动态id查询动态详细信息
            PostDAO dao = new PostDAO();
            Post post = dao.getPostDetail(postID);
            // 将查询到的动态信息存入request请求域
            request.setAttribute("post", post);
            // 根据动态id查询动态的所有评论
            List<Comment> commentList = dao.getPostDetail(postID).getCommentList();
            // 将查询到的职位列表存入request请求域
            request.setAttribute("commentList", commentList);
            // 请求转发
            request.getRequestDispatcher("postdetail.jsp").forward(
                    request, response);
        } else if ("pageList".equals(type)) {
            // 动态列表分页显示功能
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null || "".equals(pageNo))
                pageNo = "1";
            // 动态信息分页展示功能实现JavaBean
            PostPageBean pagination = new PostPageBean(10,
                    Integer.parseInt(pageNo));
            request.setAttribute("pagination", pagination);
            request.getRequestDispatcher("include_postList.jsp").include(
                    request, response);
        } else if ("pageList2".equals(type)) {
            // 动态列表分页显示功能
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null || "".equals(pageNo))
                pageNo = "1";
            // 动态信息分页展示功能实现JavaBean
            PostPageBean pagination = new PostPageBean(10,
                    Integer.parseInt(pageNo));
            request.setAttribute("pagination", pagination);
            request.getRequestDispatcher("include_postList2.jsp").include(
                    request, response);
        }
    }

}
