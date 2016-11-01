package ru.itis.network_headlines.com;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.itis.utils.GzipPageParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UseR7 on 25.10.2016.
 */
public class HTMLHeadlinesParser {

    final static String BASE_URL = "http://www.headlines.ru/science/";
    private GzipPageParser parser = new GzipPageParser();

    public List<String> getNews(String query) throws IOException, JSONException {
        List<String> list = new ArrayList<String>();
        String data;
        data = parser.getFullPageData(BASE_URL, query);
        Document doc;
        doc = Jsoup.parse(data);
        Elements e = doc.select("span.idef");
        for (Element element:e){
            list.add(element.text());
        }
        return list;
    }
}
