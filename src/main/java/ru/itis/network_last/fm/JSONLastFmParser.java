package ru.itis.network_last.fm;

import org.json.JSONException;
import org.json.JSONObject;
import ru.itis.utils.PageParser;
import ru.itis.utils.interfaces.Parser;

/**
 * Created by UseR7 on 06.10.2016.
 */
public class JSONLastFmParser {
    private static String BASE_URL = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&api_key=4b283c9e1340a9fc186b3670a240284a&format=json&artist=";

    public static long getPlayCount(String singer) throws JSONException {
        Parser parser = new PageParser();

        long playcount;
        JSONObject jObj = new JSONObject(parser.getFullPageData(BASE_URL, singer));
        JSONObject artistObj = jObj.getJSONObject("artist");
        JSONObject statsObj = artistObj.getJSONObject("stats");

        playcount = statsObj.getLong("playcount");
        return playcount;
    }
}
