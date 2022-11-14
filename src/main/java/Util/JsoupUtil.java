package Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {
    public static List<String> dogBreadJsoup() {
        List<String> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect("https://www.akc.org/expert-advice/dog-breeds/most-popular-dog-breeds-of-2021/").get();
            Elements e = document.select("#main-content > div.article-body > div.content-body > div > div > table > tbody > tr > td > table > tbody > tr");
            int count = 0;
            for (Element el : e) {
                String breed = el.select("a").text();
                list.add(breed);
                count++;
                if (count == 20) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.remove(0);
        return list;
    }
}
