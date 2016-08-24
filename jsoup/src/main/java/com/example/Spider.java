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
        try {
            document = Jsoup.connect(url).get();
            Elements select = document.select(".hm a");

            Elements titles = select.select("p");
            Elements urls = select.select("img");
            Elements views = select.select("div");
            Element element = views.get(0);
            String span = element.attr("span");
//            Elements urls = select.select("p");
            List<String> listTitle = new ArrayList<>();
            List<String> listView = new ArrayList<>();
            for (int i = 0; i < titles.size(); i++) {
                listTitle.add(titles.get(i).text());
                listView.add(urls.get(i).attr("name"));
            }
//            System.out.println(listTitle.size()+"  "+listTitle.toString());
            System.out.println(span);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
