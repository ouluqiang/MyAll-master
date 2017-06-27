package com.olq.mytotal.bean;

/**
 * Created by Administrator on 2017/3/1.
 */

public class BookBean {

    private String path;
    private String size;
    private String title;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookBean(String path, String size, String title) {
        this.path = path;
        this.size = size;
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
