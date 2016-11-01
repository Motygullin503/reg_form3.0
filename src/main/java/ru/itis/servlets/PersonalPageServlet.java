package ru.itis.servlets;

import org.json.JSONException;
import ru.itis.entities.NewsItem;
import ru.itis.entities.Weather;
import ru.itis.network_headlines.com.HTMLHeadlinesParser;
import ru.itis.network_last.fm.JSONLastFmParser;
import ru.itis.network_weather.JSONWeatherParser;
import ru.itis.repositories.SQLUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class PersonalPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

if(session.getAttribute("isAdmin").equals("true")){
    ArrayList list= (ArrayList) SQLUserRepository.getAll();
    req.setAttribute("list", list);
    getServletContext().getRequestDispatcher("/WEB-INF/view/Admin.jsp").forward(req, resp);
    return;
}
        try {
            Weather weather;
            weather = JSONWeatherParser.getWeather((String) session.getAttribute("city"));

            HTMLHeadlinesParser parser = new HTMLHeadlinesParser();

            int id = (Integer) session.getAttribute("user");
            ArrayList<String> list = (ArrayList<String>) SQLUserRepository.getPreferences(id);


            req.setAttribute("city", session.getAttribute("city"));
            req.setAttribute("description", weather.currentCondition.getDescription());
            req.setAttribute("temperature", (int) weather.currentCondition.getTemp()+" C°");
            req.setAttribute("list", parser.getNews(list.get(3)));
           // req.setAttribute("list2", parser.getNews(list.get(1)));

            long playcount = JSONLastFmParser.getPlayCount(list.get(2));
            req.setAttribute("username", SQLUserRepository.getUsername(id));
            req.setAttribute("fav_singer", list.get(2));
            req.setAttribute("playcount", playcount);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/main_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ToDo:update for parameters
    }
}
