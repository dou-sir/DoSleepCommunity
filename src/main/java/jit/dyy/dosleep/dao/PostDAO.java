package jit.dyy.dosleep.dao;

import jit.dyy.dosleep.bean.Comment;
import jit.dyy.dosleep.bean.Like;
import jit.dyy.dosleep.bean.Post;
import jit.dyy.dosleep.bean.User;
import jit.dyy.dosleep.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO {
    /**
     * 添加动态
     * @param post
     */
    public void addPost(Post post) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO tb_post(user_id,post_content,post_annex,post_time) VALUES(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,post.getUser_id());
            pstmt.setString(2, post.getPost_content());
            pstmt.setString(3, post.getPost_annex());
            pstmt.setTimestamp(4, new Timestamp(post.getPost_time().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 根据最新时间获取动态
     * @param flag 当前已显示的动态条数
     * @return
     */
    public List<Post> getPostsByTime(int flag) {
        // 定义记录索引值
        int firstIndex = flag-1;
        // 每次最大数目
        int size = 10;
        List<Post> list = new ArrayList<Post>();
        Connection connection = DBUtil.getConnection();
        if (connection == null)
            return null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM tb_post ORDER BY post_time DESC LIMIT ?,?");
            pstmt.setInt(1, firstIndex);
            pstmt.setInt(2, size);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post(
                        rs.getInt("post_id"),
                        rs.getInt("user_id"),
                        rs.getString("post_content"),
                        rs.getString("post_annex"),
                        rs.getDate("post_time"),
                        rs.getInt("post_clout"),
                        rs.getInt("post_like"),
                        rs.getInt("post_comment")
                );
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, connection);
        }
        return list;
    }

    public List<Post> getPostsByTime(int flag, int user_id) {
        // 定义记录索引值
        int firstIndex = flag-1;
        // 每次最大数目
        int size = 10;
        List<Post> list = new ArrayList<Post>();
        Connection connection = DBUtil.getConnection();
        if (connection == null)
            return null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM tb_post ORDER BY post_time DESC LIMIT ?,?");
            pstmt.setInt(1, firstIndex);
            pstmt.setInt(2, size);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post(
                        rs.getInt("post.post_id"),
                        rs.getInt("post.user_id"),
                        rs.getString("post_content"),
                        rs.getString("post_annex"),
                        rs.getDate("post_time"),
                        rs.getInt("post_clout"),
                        rs.getInt("post_like"),
                        rs.getInt("post_comment")
                );
                //todo like
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, connection);
        }
        return list;
    }

    /**
     * 根据热度获取动态
     * @param flag 当前已显示的动态条数
     * @return
     */
    public List<Post> getPostsByClout(int flag) {
        // 定义记录索引值
        int firstIndex = flag-1;
        // 每次最大数目
        int size = 10;
        List<Post> list = new ArrayList<Post>();
        Connection connection = DBUtil.getConnection();
        if (connection == null)
            return null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM tb_post ORDER BY post_clout DESC LIMIT ?,?");
            pstmt.setInt(1, firstIndex);
            pstmt.setInt(2, size);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post(
                        rs.getInt("post_id"),
                        rs.getInt("user_id"),
                        rs.getString("post_content"),
                        rs.getString("post_annex"),
                        rs.getDate("post_time"),
                        rs.getInt("post_clout"),
                        rs.getInt("post_like"),
                        rs.getInt("post_comment")
                );
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, connection);
        }
        return list;
    }

    public List<Post> getPostsByClout(int flag, int user_id) {
        // 定义记录索引值
        int firstIndex = flag-1;
        // 每次最大数目
        int size = 10;
        List<Post> list = new ArrayList<Post>();
        Connection connection = DBUtil.getConnection();
        if (connection == null)
            return null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM tb_post ORDER BY post_clout DESC LIMIT ?,?");
            pstmt.setInt(1, firstIndex);
            pstmt.setInt(2, size);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post(
                        rs.getInt("post.post_id"),
                        rs.getInt("post.user_id"),
                        rs.getString("post_content"),
                        rs.getString("post_annex"),
                        rs.getDate("post_time"),
                        rs.getInt("post_clout"),
                        rs.getInt("post_like"),
                        rs.getInt("post_comment")
                );
                //todo like
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, connection);
        }
        return list;
    }

    //todo 关键词查询
    /**
     * 查询个人已点赞的动态
     * @param user_id
     * @param flag 当前已显示的动态条数
     * @return
     */
    public List<Post> getPostsByLike(int flag, int user_id) {
        // 定义记录索引值
        int firstIndex = flag-1;
        // 每次最大数目
        int size = 10;
        List<Post> list = new ArrayList<Post>();
        Connection connection = DBUtil.getConnection();
        if (connection == null)
            return null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM tb_post INNER JOIN tb_like ON tb_post.post_id=tb_like.post_id " +
                            "AND tb_like.user_id=? ORDER BY like_time DESC LIMIT ?,?");
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, firstIndex);
            pstmt.setInt(3, size);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post= new Post(
                        rs.getInt("tb_post.post_id"),
                        rs.getInt("tb_post.user_id"),
                        rs.getString("post_content"),
                        rs.getString("post_annex"),
                        rs.getDate("post_time"),
                        rs.getInt("post_clout"),
                        rs.getInt("post_like"),
                        rs.getInt("post_comment"),
                        rs.getBoolean("islike")
                );
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, connection);
        }
        return list;
    }

    /**
     * 获取动态详情
     * @param post_id
     * @return
     */
    public Post getPostDetail(int post_id) {
        Post post = new Post();
        String sql = "SELECT * FROM tb_post WHERE post_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                post.setPsot_id(rs.getInt("post_id"));
                post.setUser_id(rs.getInt("user_id"));
                post.setPost_content(rs.getString("post_content"));
                post.setPost_annex(rs.getString("post_annex"));
                post.setPost_time(rs.getTimestamp("post_time"));
                post.setPost_clout(rs.getInt("post_clout"));
                post.setPost_like(rs.getInt("post_like"));
                post.setPost_comment(rs.getInt("post_comment"));
            }
            //加载评论
            Comment comment = new Comment();
            String sql2 = "SELECT * FROM tb_comment WHERE post_id=?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, post_id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                comment.setUser_id(rs.getInt("user_id"));
                comment.setComment_content(rs.getString("comment_content"));
                comment.setComment_time(rs.getTimestamp("comment_time"));
                post.getCommentList().add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
        return post;
    }

    public Post getPostDetail(int post_id, int user_id) {//todo
        Post post = new Post();
        String sql = "SELECT * FROM tb_post WHERE post_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                post.setPsot_id(rs.getInt("post_id"));
                post.setUser_id(rs.getInt("user_id"));
                post.setPost_content(rs.getString("post_content"));
                post.setPost_annex(rs.getString("post_annex"));
                post.setPost_time(rs.getTimestamp("post_time"));
                post.setPost_clout(rs.getInt("post_clout"));
                post.setPost_like(rs.getInt("post_like"));
                post.setPost_comment(rs.getInt("post_comment"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
        return post;
    }

    public boolean isliked(int post_id, int user_id) {
        Like like = new Like();
        String sql = "SELECT * FROM tb_like WHERE post_id=? AND user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_id);
            pstmt.setInt(2, user_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                like.setIslike(rs.getBoolean("islike"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
        return like.getIslike();
    }

    /**
     * 更新动态信息
     * @param post
     */
    public void updatePost(Post post) {
        String sql = "UPDATE tb_post "
                + "SET post_clout=?, post_like=?, post_comment=? "
                + "WHERE post_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post.getPost_clout());
            pstmt.setInt(2, post.getPost_like());
            pstmt.setInt(3, post.getPost_comment());
            pstmt.setInt(4, post.getPsot_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 根据post_id删除动态
     * @param post_id
     */
    public void deletePost(int post_id) {
        String sql = "DELETE FROM tb_post WHERE post_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }

    }

    /**
     * 点赞并更新post表
     * @param post
     * @param like
     */
    public void addPostLike(Post post, Like like) {
        String sql = "INSERT INTO tb_like (post_id, user_id, islike, like_time) " +
                "VALUES(?,?,?,?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            // 关闭自动提交
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, like.getPsot_id());
            pstmt.setInt(2, like.getUser_id());
            pstmt.setInt(3, like.getIslike()?1:0 );
            pstmt.setTimestamp(4,new Timestamp(like.getLike_time().getTime()));
            pstmt.executeUpdate();
            pstmt.close();
            // 更新post表like项
            String sql2 = "UPDATE tb_post SET post_clout=?, post_like=? "
                    + "WHERE post_id=?";
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, post.getPost_clout());
            pstmt.setInt(2, post.getPost_like());
            pstmt.setInt(3, post.getPsot_id());
            // 事务提交
            conn.commit();
        } catch (SQLException e) {
            try {
                // 事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 取消点赞并更新post表
     * @param post
     * @param like
     */
    public void deletePostLike(Post post, Like like) {
        String sql = "DELETE FROM tb_like WHERE post_id=? AND user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            // 关闭自动提交
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, like.getPsot_id());
            pstmt.setInt(2, like.getUser_id());
            pstmt.executeUpdate();
            pstmt.close();
            // 更新post表like项
            String sql2 = "UPDATE tb_post SET post_clout=?, post_like=? "
                    + "WHERE post_id=?";
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, post.getPost_clout());
            pstmt.setInt(2, post.getPost_like());
            pstmt.setInt(3, post.getPsot_id());
            // 事务提交
            conn.commit();
        } catch (SQLException e) {
            try {
                // 事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 评论并更新post表
     * @param post
     * @param comment
     */
    public void addPostComment(Post post, Comment comment) {
        String sql = "INSERT INTO tb_comment (post_id, user_id, comment_content, comment_time) " +
                "VALUES(?,?,?,?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            // 关闭自动提交
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment.getPsot_id());
            pstmt.setInt(2, comment.getUser_id());
            pstmt.setString(3, comment.getComment_content() );
            pstmt.setTimestamp(4,new Timestamp(comment.getComment_time().getTime()));
            pstmt.executeUpdate();
            pstmt.close();
            // 更新post表comment项
            String sql2 = "UPDATE tb_post SET post_clout=?, post_comment=? "
                    + "WHERE post_id=?";
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, post.getPost_clout());
            pstmt.setInt(2, post.getPost_comment());
            pstmt.setInt(3, post.getPsot_id());
            // 事务提交
            conn.commit();
        } catch (SQLException e) {
            try {
                // 事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 删除评论并更新post表
     * @param post
     * @param comment
     */
    public void deletePostComment(Post post, Comment comment) {
        String sql = "DELETE FROM tb_comment WHERE post_id=? AND user_id=? AND comment_time=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            // 关闭自动提交
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment.getPsot_id());
            pstmt.setInt(2, comment.getUser_id());
            pstmt.setTimestamp(3, new Timestamp(comment.getComment_time().getTime()));
            pstmt.executeUpdate();
            pstmt.close();
            // 更新post表like项
            String sql2 = "UPDATE tb_post SET post_clout=?, post_like=? "
                    + "WHERE post_id=?";
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, post.getPost_clout());
            pstmt.setInt(2, post.getPost_comment());
            pstmt.setInt(3, post.getPsot_id());
            // 事务提交
            conn.commit();
        } catch (SQLException e) {
            try {
                // 事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }
//todo
//
//    /**
//     * 分页根据最新时间获取动态
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    public List<Post> getPostsByTime(int pageNo, int pageSize) {
//        // 定义本页记录索引值
//        int firstIndex = pageSize * (pageNo-1);
//        List<Post> list = new ArrayList<Post>();
//        Connection connection = DBUtil.getConnection();
//        if (connection == null)
//            return null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = connection.prepareStatement(
//                    "SELECT * FROM tb_post ORDER BY post_time DESC LIMIT ?,?");
//            pstmt.setInt(1, firstIndex);
//            pstmt.setInt(2, pageSize);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Post post= new Post(
//                        rs.getInt("post_id"),
//                        rs.getInt("user_id"),
//                        rs.getString("post_content"),
//                        rs.getString("post_annex"),
//                        rs.getDate("post_time"),
//                        rs.getInt("post_clout"),
//                        rs.getInt("post_like"),
//                        rs.getInt("post_comment")
//                );
//                list.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closeJDBC(rs, pstmt, connection);
//        }
//        return list;
//    }
//
//    public List<Post> getPostsByTime(int user_id, int pageNo, int pageSize)
//    {
//        // 定义本页记录索引值
//        int firstIndex = pageSize * (pageNo-1);
//        List<Post> list = new ArrayList<Post>();
//        Connection connection = DBUtil.getConnection();
//        if (connection == null)
//            return null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = connection.prepareStatement(
//                    "SELECT * FROM tb_post LEFT JOIN tb_like ON tb_post.post_id=tb_like.post_id "  +
//                            " ORDER BY post_time DESC LIMIT ?,?");
//            pstmt.setInt(1, firstIndex);
//            pstmt.setInt(2, pageSize);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Post post= new Post(
//                        rs.getInt("post.post_id"),
//                        rs.getInt("post.user_id"),
//                        rs.getString("post_content"),
//                        rs.getString("post_annex"),
//                        rs.getDate("post_time"),
//                        rs.getInt("post_clout"),
//                        rs.getInt("post_like"),
//                        rs.getInt("post_comment"),
//                        user_id == rs.getInt("like.user_id")
//                );
//                list.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closeJDBC(rs, pstmt, connection);
//        }
//        return list;
//    }
//
//    /**
//     * 分页根据热度获取动态
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    public List<Post> getPostsByClout(int pageNo, int pageSize) {
//        // 定义本页记录索引值
//        int firstIndex = pageSize * (pageNo-1);
//        List<Post> list = new ArrayList<Post>();
//        Connection connection = DBUtil.getConnection();
//        if (connection == null)
//            return null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = connection.prepareStatement(
//                    "SELECT * FROM tb_post ORDER BY post_clout DESC LIMIT ?,?");
//            pstmt.setInt(1, firstIndex);
//            pstmt.setInt(2, pageSize);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Post post= new Post(
//                        rs.getInt("post_id"),
//                        rs.getInt("user_id"),
//                        rs.getString("post_content"),
//                        rs.getString("post_annex"),
//                        rs.getDate("post_time"),
//                        rs.getInt("post_clout"),
//                        rs.getInt("post_like"),
//                        rs.getInt("post_comment")
//                );
//                list.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closeJDBC(rs, pstmt, connection);
//        }
//        return list;
//    }
//
//    public List<Post> getPostsByClout(int user_id, int pageNo, int pageSize) {
//        // 定义本页记录索引值
//        int firstIndex = pageSize * (pageNo-1);
//        List<Post> list = new ArrayList<Post>();
//        Connection connection = DBUtil.getConnection();
//        if (connection == null)
//            return null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = connection.prepareStatement(
//                    "SELECT * FROM tb_post LEFT JOIN tb_like ON tb_post.post_id=tb_like.post_id "  +
//                            " ORDER BY post_time DESC LIMIT ?,?");
//            pstmt.setInt(1, firstIndex);
//            pstmt.setInt(2, pageSize);
//
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Post post= new Post(
//                        rs.getInt("post.post_id"),
//                        rs.getInt("post.user_id"),
//                        rs.getString("post_content"),
//                        rs.getString("post_annex"),
//                        rs.getDate("post_time"),
//                        rs.getInt("post_clout"),
//                        rs.getInt("post_like"),
//                        rs.getInt("post_comment"),
//                        user_id == rs.getInt("like.user_id")
//                );
//                list.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closeJDBC(rs, pstmt, connection);
//        }
//        return list;
//    }
//
//    public List<Post> findPostsByKey
//
//    /**
//     * 分页查询个人已点赞的动态
//     * @param user_id
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    public List<Post> getPostsByLike(int user_id, int pageNo, int pageSize) {
//        // 定义本页记录索引值
//        int firstIndex = pageSize * (pageNo-1);
//        List<Post> list = new ArrayList<Post>();
//        Connection connection = DBUtil.getConnection();
//        if (connection == null)
//            return null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            pstmt = connection.prepareStatement(
//                    "SELECT * FROM tb_post INNER JOIN tb_like ON tb_post.post_id=tb_like.post_id " +
//                            "AND tb_like.user_id=? ORDER BY like_time DESC LIMIT ?,?");
//            pstmt.setInt(1, user_id);
//            pstmt.setInt(2, firstIndex);
//            pstmt.setInt(3, pageSize);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Post post= new Post(
//                        rs.getInt("tb_post.post_id"),
//                        rs.getInt("tb_post.user_id"),
//                        rs.getString("post_content"),
//                        rs.getString("post_annex"),
//                        rs.getDate("post_time"),
//                        rs.getInt("post_clout"),
//                        rs.getInt("post_like"),
//                        rs.getInt("post_comment"),
//                        rs.getBoolean("islike")
//                );
//                list.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closeJDBC(rs, pstmt, connection);
//        }
//        return list;
//    }

}
