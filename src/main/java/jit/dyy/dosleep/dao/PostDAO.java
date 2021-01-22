package jit.dyy.dosleep.dao;

import jit.dyy.dosleep.bean.Post;
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

    public List<Post> getPostsByTime(int flag){
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
                        rs.getInt("post_like")
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

    public void updatePost(Post post){

    }


}
