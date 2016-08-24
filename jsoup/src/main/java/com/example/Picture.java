package com.example;

/**
 * Created by dell on 2016/8/25.
 */
public class Picture {
    private String title;
    private int views;
    private int favs;
    private int url;

    public Picture(String title, int views, int favs, int url) {
        this.title = title;
        this.views = views;
        this.favs = favs;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "title='" + title + '\'' +
                ", views=" + views +
                ", favs=" + favs +
                ", url=" + url +
                '}';
    }
}
