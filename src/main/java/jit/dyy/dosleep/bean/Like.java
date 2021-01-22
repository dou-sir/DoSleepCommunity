package jit.dyy.dosleep.bean;

import java.util.Date;

public class Like {
    private int psot_id;
    private int user_id;
    private Boolean islike;
    private Date like_time;

    public Like() {
        super();
    }

    public Like(int psot_id, int user_id, Boolean islike, Date like_time) {
        super();
        this.psot_id = psot_id;
        this.user_id = user_id;
        this.islike = islike;
        this.like_time = like_time;
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

    public Boolean getIslike() {
        return islike;
    }

    public void setIslike(Boolean islike) {
        this.islike = islike;
    }

    public Date getLike_time() {
        return like_time;
    }

    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }
}
