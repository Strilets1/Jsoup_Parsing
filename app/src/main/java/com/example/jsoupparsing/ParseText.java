package com.example.jsoupparsing;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ParseText extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String str = " ";
        try {
            Document document = Jsoup.connect(strings[0]).get();
            Element element = document.select(".all-category-detali").first();
            str = element.text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
