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
     * user信息注册
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

    /**
     * 根据user标识查询基本信息
     * @param user_id
     * @return
     */
    public User findUserByID(int user_id) {
        User user = new User();
        String sql = "SELECT * FROM tb_user WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd"),
                        rs.getString("user_tel"),
                        rs.getDate("user_birth"),
                        rs.getString("user_img"),
                        rs.getString("user_slogan")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
        return user;
    }

    /**
     * 修改个人信息
     * @param user
     */
    public void updateUser(User user) {
        String sql = "UPDATE tb_user "
                + "SET user_name=?, user_tel=?, user_birth=?, user_slogan=? "
                + "WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_name());
            pstmt.setString(2, user.getUser_tel());

            pstmt.setDate(3, (java.sql.Date) user.getUser_birth());
            pstmt.setString(4, user.getUser_slogan());
            pstmt.setInt(5,user.getUser_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 修改用户头像
     * @param user_id
     * @param newFilePath
     */
    public void updateHeadShot(int user_id, String newFilePath) {
        String sql = "UPDATE tb_user SET user_img=? WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newFilePath);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 修改用户密码
     * @param user_id
     * @param user_pwd
     */
    public void updatePwd(int user_id, String user_pwd) {
        String sql = "UPDATE tb_user SET user_pwd=? WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_pwd);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    /**
     * 注销用户
     * @param user_id
     */
    public void deleteUser(int user_id) {
        String sql = "DELETE FROM tb_user WHERE user_id=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }
}
