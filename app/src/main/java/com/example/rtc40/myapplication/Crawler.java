package com.example.rtc40.myapplication;
import android.util.Log;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Crawler {

    public static String getWord(String word) {
        try {
            Log.i("Crawler.get",word);
            Document doc = Jsoup.connect("http://tw.xyzdict.com/english-chinese/"+word).get();
            Element element = doc.select("div.panel-body").get(1);
            System.out.println(element.text());
            return element.text();
        }catch (Exception e){
            System.out.println("can't find");
        }
        return word;
    }
}
