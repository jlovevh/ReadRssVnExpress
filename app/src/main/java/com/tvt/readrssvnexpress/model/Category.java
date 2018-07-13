package com.tvt.readrssvnexpress.model;

public class Category {

    private String title,link;

    public Category(String title, String link) {
        this.title = title;
        this.link = link;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
