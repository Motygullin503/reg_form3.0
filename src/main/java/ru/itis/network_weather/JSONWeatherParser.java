package ru.itis.network_weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.itis.entities.Weather;
import ru.itis.utils.PageParser;
import ru.itis.utils.interfaces.Parser;


public class JSONWeatherParser {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?appid=aa4ccede8bf4a954cec61c24c987c50c&units=metric&q=";
    private static String IMG_URL = "http://openweathermap.org/img/w/";



    public static Weather getWeather(String location) throws JSONException {
        Weather weather = new Weather();
        Parser parser = new PageParser();
        // Creating JSONObject from the data
        JSONObject jObj = new JSONObject(parser.getFullPageData(BASE_URL, location));


        JSONObject sysObj = getObject("sys", jObj);


        // Getting weather info
        JSONArray jArr = jObj.getJSONArray("weather");

        JSONObject JSONWeather = jArr.getJSONObject(0);
        weather.currentCondition.setId(getInt("id", JSONWeather));
        weather.currentCondition.setDescription(getString("description", JSONWeather));
        weather.currentCondition.setMain(getString("main", JSONWeather));
        weather.currentCondition.setIcon(getString("icon", JSONWeather));

        JSONObject mainObj = getObject("main", jObj);
        weather.currentCondition.setTemp(getFloat("temp", mainObj));

        return weather;
    }


    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        return jObj.getJSONObject(tagName);

    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }


    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }

}
