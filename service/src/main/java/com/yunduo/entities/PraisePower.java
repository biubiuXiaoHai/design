package com.yunduo.entities;

public class PraisePower {
    private Integer id;

    private Integer share_id;

    private Integer person_id;

    private String person_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShare_id() {
        return share_id;
    }

    public void setShare_id(Integer share_id) {
        this.share_id = share_id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name == null ? null : person_name.trim();
    }
}