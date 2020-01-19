package com.yunduo.entities;

import java.util.Date;

public class Users {
    private Integer account;

    private String name;

    private String phone;

    private String password;

    private String sex;

    private Integer birthday;

    private Byte constellationsid;

    private String fondness;

    private String signature;

    private Byte vip_static;

    private Date create_time;

    private byte[] avatar;

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Byte getConstellationsid() {
        return constellationsid;
    }

    public void setConstellationsid(Byte constellationsid) {
        this.constellationsid = constellationsid;
    }

    public String getFondness() {
        return fondness;
    }

    public void setFondness(String fondness) {
        this.fondness = fondness == null ? null : fondness.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Byte getVip_static() {
        return vip_static;
    }

    public void setVip_static(Byte vip_static) {
        this.vip_static = vip_static;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}