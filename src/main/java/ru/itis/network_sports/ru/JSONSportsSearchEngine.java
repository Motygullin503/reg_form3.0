package ru.itis.network_sports.ru;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.itis.utils.GzipPageParser;
import ru.itis.utils.interfaces.Parser;

class JSONSportsSearchEngine {
    final static String URL = "http://www.sports.ru/search/search.json?query=";

    String search(String query) throws JSONException {
        String id;
        GzipPageParser parser = new GzipPageParser();
        JSONObject object = new JSONObject(parser.getFullPageData(URL, query));

        JSONArray array = object.getJSONArray("suggestions");
        JSONObject first = array.getJSONObject(0);
        id = first.getString("id");
        return id;
    }
}
