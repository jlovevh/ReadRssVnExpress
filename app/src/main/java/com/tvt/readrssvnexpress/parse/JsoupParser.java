package com.tvt.readrssvnexpress.parse;

import android.util.Log;

import com.tvt.readrssvnexpress.model.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupParser {

        public List<News> getAllXml (String link){

            List<News> arrnews =new ArrayList<>();
            try {
                Document document= Jsoup.connect(link).timeout(15000).get();
                Elements elements =document.select("item");
                for (Element element:elements) {

                    Element elementTitle = element.getElementsByTag("title").first();
                    Element elementPubDate = element.getElementsByTag("pubDate").first();

                    Element elementLink = element.getElementsByTag("link").first();
                    Element elementDes = element.getElementsByTag("description").first();

                    Document doc = Jsoup.parse(String.valueOf(elementDes));
                    String text="",src="";
                    for (Element desc : doc.select("description")) {
                        String unescapedHtml = desc.text();
                         src = Jsoup.parse(unescapedHtml).select("img").first().attr("src");
                         text = Jsoup.parse(unescapedHtml).text();

                    }

                    String title=elementTitle.text();
                    String time=elementPubDate.text();
                    String linkE=elementLink.text();
                    arrnews.add(new News(src,title,text,linkE,time));
                    Log.d("tag",title);
                    Log.d("tag",time);
                    Log.d("tag",linkE);
                    Log.d("tag",src);
                    Log.d("tag",text);
                    Log.d("tag",""+arrnews.size());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


            return  arrnews;
        }
}
