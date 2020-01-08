package com.example.jsoupparsing;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class ParseTitle extends AsyncTask<Void, Void, HashMap<String, String>> {
    @Override
    protected HashMap<String, String> doInBackground(Void... voids) {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            Document document = Jsoup.connect("https://marketer.ua/category/techno/gadgets/").get();
            Elements elements = document.select(".recent-articles_item");
            for (Element element: elements) {
                Element element1 = element.select("a[href]").first();
                hashMap.put(element.text(), element1.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hashMap;
    }
}
