package ru.itis.servlets;

import org.json.JSONException;
import ru.itis.entities.User;
import ru.itis.network_sports.ru.HTMLSportsParser;
import ru.itis.repositories.SQLUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class AutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email")!=null&&req.getAttribute("status")!=null) {
            resp.sendRedirect("/personal");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/aut_view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        List<User> users = SQLUserRepository.getAll();
        boolean found = false;

        for (User user : users) {
            String correctEmail = user.getEmail().replace("\"", "");
            if (correctEmail.equals(email)) {

                if (user.getPassword().replace("salt", "").replace("\"", "").equals(password)) {

                    HttpSession session = req.getSession();
                    session.setAttribute("user", SQLUserRepository.getId(email));
                    session.setAttribute("preferences", SQLUserRepository.getPreferences(SQLUserRepository.getId(email)));



                    session.setAttribute("city", user.getCity().replace("\"", ""));
                    session.setAttribute("email", email);
                    session.setAttribute("isAdmin", user.getIsAdmin());
                    session.setMaxInactiveInterval(30 * 60);
                    found = true;

                        resp.sendRedirect("/personal");
                }
            }
        }

        if (!found) {
            req.setAttribute("message", "Check your Email, password or Register");
            req.setAttribute("ref", "To registration page");
            getServletContext().getRequestDispatcher("/WEB-INF/view/aut_view.jsp").forward(req, resp);
        }

    }
}
