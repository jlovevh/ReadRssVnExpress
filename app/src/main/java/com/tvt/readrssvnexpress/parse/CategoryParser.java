package com.tvt.readrssvnexpress.parse;

import android.util.Log;

import com.tvt.readrssvnexpress.model.Category;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryParser {

    public static final String TAG = "tien.mtp";


//    public List<Category> parserCategory(String link) {
//        List<Category> arrCategory = new ArrayList<>();
//        String title = "";
//        String linkCategory = "";
//        try {
//            Document document = Jsoup.connect(link).timeout(15000).get();
//            Elements categoryElements = document.getElementsByClass("list_rss");
//
//            for (Element element : categoryElements) {
//
//                Element elementTitle=element.getElementsByClass("rss_txt").first();
//                if(elementTitle!=null){
//                    title=elementTitle.text();
//                }
//
//
//                Element elementLink=element.getElementsByClass("rss_txt").first();
//                if(elementLink!=null){
//                    link=elementLink.attr("href");
//                }
//
//                arrCategory.add(new Category(title,link));
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return arrCategory;
//    }
}
