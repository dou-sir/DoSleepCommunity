package jit.dyy.dosleep.bean;

import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_tel;
    private Date user_birth;
    private String user_img;
    private String user_slogan;

    public User() {
        super();
    }

    public User(int user_id, String user_name, String user_pwd) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    public User(String user_name, String user_pwd, String user_tel) {
        super();
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_tel = user_tel;
    }

    public User(int user_id, String user_name, String user_pwd, String user_tel, Date user_birth, String user_img, String user_slogan) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_tel = user_tel;
        this.user_birth = user_birth;
        this.user_img = user_img;
        this.user_slogan = user_slogan;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_slogan() {
        return user_slogan;
    }

    public void setUser_slogan(String user_slogan) {
        this.user_slogan = user_slogan;
    }
}
