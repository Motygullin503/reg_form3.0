package ru.itis.network_sports.ru;

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
public class HTMLSportsParser {
    private final static String URL = "http://www.sports.ru/tags/";
    private JSONSportsSearchEngine engine = new JSONSportsSearchEngine();
    private GzipPageParser parser = new GzipPageParser();

    public List<String> getNews(String query) throws IOException, JSONException{
        List<String> data = new ArrayList<String>();
        String html;
        html = parser.getFullPageData(URL, engine.search(query));
        Document doc = Jsoup.parse(html);
        Elements e = doc.select("a.short-text");
        for (Element element:e){
            data.add(element.text());
        }
        return data;
    }

}
