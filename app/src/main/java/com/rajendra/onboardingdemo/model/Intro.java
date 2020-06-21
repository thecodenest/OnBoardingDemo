package com.rajendra.onboardingdemo.model;

public class Intro {

    String title;
    String desc;
    Integer imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Intro(String title, String desc, Integer imageUrl) {
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
