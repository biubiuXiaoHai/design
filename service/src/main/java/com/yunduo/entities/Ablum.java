package com.yunduo.entities;

public class Ablum {
    private Integer id;

    private Integer master_id;

    private String ablum_title;

    private String ablum_head;

    private String ablum_description;

    private Integer picture_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaster_id() {
        return master_id;
    }

    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }

    public String getAblum_title() {
        return ablum_title;
    }

    public void setAblum_title(String ablum_title) {
        this.ablum_title = ablum_title == null ? null : ablum_title.trim();
    }

    public String getAblum_head() {
        return ablum_head;
    }

    public void setAblum_head(String ablum_head) {
        this.ablum_head = ablum_head == null ? null : ablum_head.trim();
    }

    public String getAblum_description() {
        return ablum_description;
    }

    public void setAblum_description(String ablum_description) {
        this.ablum_description = ablum_description == null ? null : ablum_description.trim();
    }

    public Integer getPicture_number() {
        return picture_number;
    }

    public void setPicture_number(Integer picture_number) {
        this.picture_number = picture_number;
    }
}