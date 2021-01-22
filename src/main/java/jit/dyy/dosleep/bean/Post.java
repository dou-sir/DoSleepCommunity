package jit.dyy.dosleep.bean;

import java.util.Date;

public class Post {
    private int psot_id;
    private int user_id;
    private String post_content;
    private String post_annex;
    private Date post_time;
    private int post_clout;
    private int post_like;

    public Post() {
        super();
    }

    public Post(int user_id, String post_content, String post_annex, Date post_time) {
        super();
        this.user_id = user_id;
        this.post_content = post_content;
        this.post_annex = post_annex;
        this.post_time = post_time;
    }

    public Post(int psot_id, int user_id, String post_content, String post_annex, Date post_time, int post_clout, int post_like) {
        super();
        this.psot_id = psot_id;
        this.user_id = user_id;
        this.post_content = post_content;
        this.post_annex = post_annex;
        this.post_time = post_time;
        this.post_clout = post_clout;
        this.post_like = post_like;
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

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_annex() {
        return post_annex;
    }

    public void setPost_annex(String post_annex) {
        this.post_annex = post_annex;
    }

    public Date getPost_time() {
        return post_time;
    }

    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }

    public int getPost_clout() {
        return post_clout;
    }

    public void setPost_clout(int post_clout) {
        this.post_clout = post_clout;
    }

    public int getPost_like() {
        return post_like;
    }

    public void setPost_like(int post_like) {
        this.post_like = post_like;
    }
}
