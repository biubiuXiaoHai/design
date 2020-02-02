package com.yunduo.entities;

public class Users {
    private Integer account;

    private String name;

    private String password;

    private String phone;

    private String avatar;

    private String sex;

    private Integer birthday;

    private Byte constellationsid;

    private String fondness;

    private String signature;

    private Byte vip_static;

    private Integer sum_date;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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

    public Integer getSum_date() {
        return sum_date;
    }

    public void setSum_date(Integer sum_date) {
        this.sum_date = sum_date;
    }
}