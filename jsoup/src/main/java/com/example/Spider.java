package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Spider {
    public static final String url = "http://www.2mmei.net";
    private static Document document;

    public static void main(String[] args){
        List<String> listTitle = getPicture().getListTitle();
            System.out.println(listTitle);

    }
    public static Picture getPicture(){
        Picture picture = null;
        try {
            document = Jsoup.connect(url).get();
            Elements select = document.select(".hm a");
            Elements titles = select.select("p");
            Elements urls = select.select("img");
            Elements views = select.select("#si > span");
            Element element = views.get(0);

            List<String> listTitle = new ArrayList<>();
            List<String> listView = new ArrayList<>();
            List<String> listUrl = new ArrayList<>();
            List<String> listFavs = new ArrayList<>();

            for (int i = 0; i < titles.size(); i++) {
                listTitle.add(titles.get(i).text());
                listUrl.add(urls.get(i).attr("name"));
                listView.add(views.get(2*i).text().replaceAll("\u00A0", ""));
                listFavs.add(views.get(2*i+1).text().replaceAll("\u00A0", ""));
            }
             picture = new Picture(listTitle,listView,listUrl,listFavs);
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }
}
