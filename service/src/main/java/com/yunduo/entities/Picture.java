package com.yunduo.entities;

public class Picture {
    private Integer picture_id;

    private Integer master_id;

    private Integer ablum_id;

    private String push_time;

    private String url;

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }

    public Integer getMaster_id() {
        return master_id;
    }

    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }

    public Integer getAblum_id() {
        return ablum_id;
    }

    public void setAblum_id(Integer ablum_id) {
        this.ablum_id = ablum_id;
    }

    public String getPush_time() {
        return push_time;
    }

    public void setPush_time(String push_time) {
        this.push_time = push_time == null ? null : push_time.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}