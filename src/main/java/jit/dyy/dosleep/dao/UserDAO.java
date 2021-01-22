package jit.dyy.dosleep.dao;

import jit.dyy.dosleep.bean.User;
import jit.dyy.dosleep.util.DBUtil;

import java.sql.*;
import java.util.Date;

public class UserDAO {
    /**
     * 验证用户名是否已被注册
     * @param name
     * @return
     */
    public boolean isExistUname(String name) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //查询用户名是否已经存在
        String sql = "SELECT * FROM tb_user WHERE user_name=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        return false;
    }

    /**
     * user信息注册保存
     * @param name
     * @param pwd
     * @param tel
     */
    public void register(String name, String pwd, String tel) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO tb_user(user_name,user_pwd,user_tel) VALUES(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            pstmt.setString(3, tel);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * loginByName
     * @param name
     * @param password
     * @return
     */
    public Integer loginByName(String name, String password) {
        int user_id = 0;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT user_id FROM tb_user WHERE user_name=? and user_pwd=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next())
                user_id = rs.getInt("user_id");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        return user_id;
    }

    public void update(User user) {
        String sql = "UPDATE tb_user "
                + "SET user_name=?, user_tel=?, user_birth=?, user_slogan=?, "
                + "WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_name());
            pstmt.setString(2, user.getUser_tel());

            pstmt.setDate(3, (java.sql.Date) user.getUser_birth());
            pstmt.setString(4, user.getUser_slogan());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }
}
