package jit.dyy.dosleep.bean;

import java.util.Date;

public class Comment {
    private int psot_id;
    private int user_id;
    private String comment_content;
    private Date comment_time;

    private User user;

    public Comment() {
        super();
    }

    public Comment(int psot_id, int user_id, String comment_content, Date comment_time) {
        super();
        this.psot_id = psot_id;
        this.user_id = user_id;
        this.comment_content = comment_content;
        this.comment_time = comment_time;
    }

    public Comment(int psot_id, int user_id, String comment_content, Date comment_time, User user) {
        this.psot_id = psot_id;
        this.user_id = user_id;
        this.comment_content = comment_content;
        this.comment_time = comment_time;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPsot_id() {
        return psot_id;
    }

    public void setPsot_id(int psot_id) {
        this.psot_id = psot_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
}
