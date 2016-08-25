package com.example;

import java.util.List;

/**
 * Created by dell on 2016/8/25.
 */
public class Picture {
    private List<String> listTitle;
    private List<String> listView;
    private List<String> listUrl;
    private  List<String> listFavs;

    @Override
    public String toString() {
        return "Picture{" +
                "listTitle=" + listTitle +
                ", listView=" + listView +
                ", listUrl=" + listUrl +
                ", listFavs=" + listFavs +
                '}';
    }

    public List<String> getListTitle() {
        return listTitle;
    }

    public void setListTitle(List<String> listTitle) {
        this.listTitle = listTitle;
    }

    public List<String> getListView() {
        return listView;
    }

    public void setListView(List<String> listView) {
        this.listView = listView;
    }

    public List<String> getListUrl() {
        return listUrl;
    }

    public void setListUrl(List<String> listUrl) {
        this.listUrl = listUrl;
    }

    public List<String> getListFavs() {
        return listFavs;
    }

    public void setListFavs(List<String> listFavs) {
        this.listFavs = listFavs;
    }

    public Picture(List<String> listTitle, List<String> listView, List<String> listUrl, List<String> listFavs) {
        this.listTitle = listTitle;
        this.listView = listView;
        this.listUrl = listUrl;
        this.listFavs = listFavs;
    }
}
