package com.yunduo.entities;

import java.util.Date;

public class Share {
    private Integer id;

    private Integer master_id;

    private Date share_time;

    private String picture1;

    private String picture2;

    private String picture3;

    private String picture4;

    private String picture5;

    private String picture6;

    private String picture7;

    private String picture8;

    private String picture9;

    private String words;

    private Integer saw_time;

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

    public Date getShare_time() {
        return share_time;
    }

    public void setShare_time(Date share_time) {
        this.share_time = share_time;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1 == null ? null : picture1.trim();
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2 == null ? null : picture2.trim();
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3 == null ? null : picture3.trim();
    }

    public String getPicture4() {
        return picture4;
    }

    public void setPicture4(String picture4) {
        this.picture4 = picture4 == null ? null : picture4.trim();
    }

    public String getPicture5() {
        return picture5;
    }

    public void setPicture5(String picture5) {
        this.picture5 = picture5 == null ? null : picture5.trim();
    }

    public String getPicture6() {
        return picture6;
    }

    public void setPicture6(String picture6) {
        this.picture6 = picture6 == null ? null : picture6.trim();
    }

    public String getPicture7() {
        return picture7;
    }

    public void setPicture7(String picture7) {
        this.picture7 = picture7 == null ? null : picture7.trim();
    }

    public String getPicture8() {
        return picture8;
    }

    public void setPicture8(String picture8) {
        this.picture8 = picture8 == null ? null : picture8.trim();
    }

    public String getPicture9() {
        return picture9;
    }

    public void setPicture9(String picture9) {
        this.picture9 = picture9 == null ? null : picture9.trim();
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words == null ? null : words.trim();
    }

    public Integer getSaw_time() {
        return saw_time;
    }

    public void setSaw_time(Integer saw_time) {
        this.saw_time = saw_time;
    }
}