package com.tvt.readrssvnexpress.model;

public class News {

    private String img,title,descripton,link,time;

    public News() {
    }

    public News(String img, String title, String descripton, String link, String time) {
        this.img = img;
        this.title = title;
        this.descripton = descripton;
        this.link = link;
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
