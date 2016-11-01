package ru.itis.servlets;

import ru.itis.entities.Themes;
import ru.itis.entities.User;
import ru.itis.network_sports.ru.HTMLSportsParser;
import ru.itis.repositories.SQLUserRepository;
import ru.itis.utils.GzipPageParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (req.getParameter("status") != null) {
            if (req.getParameter("status").equals("1")) {
                req.setAttribute("message", "Registration successfull");
            }
            if(req.getParameter("status").equals("0")){
                session.setAttribute("email", null);
            }
        }
        if (session.getAttribute("email")!=null) {
            resp.sendRedirect("/personal");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/view/page_view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String about = req.getParameter("about");
        String city = req.getParameter("city");
        String sub = req.getParameter("sub");
        String isAdmin = "false";
        boolean found = false;
        String fav_singer = req.getParameter("fav_singer");
        String category = req.getParameter("topic");
        String fav_team = req.getParameter("fav_team");
        String fav_sport = req.getParameter("sport");

            for (User user : SQLUserRepository.getAll()) {
                if (user.getEmail().equals(email))
                    found = true;
            }

            if (email.equals("admin@admin.ru")&&password.equals("bul")) {
                isAdmin = "true";
            }

        if (email.length() != 0 && fullname.length() != 0 && password.length() != 0 && password2.length() != 0) {
            if (password.equals(password2)) {
                if (!found) {
                    User user = new User(
                            fullname,
                            email,
                            password,
                            gender,
                            city,
                            about,
                            sub,
                            isAdmin);
                    Themes theme = new Themes(fav_team, fav_sport, fav_singer, city, category);
                    SQLUserRepository.add(user);
                    SQLUserRepository.addTheme(theme);
                    resp.sendRedirect(req.getRequestURI() + "?status=1");
                    return;
                } else {
                    req.setAttribute("message", "Already registered");

                }

            } else {
                req.setAttribute("name", fullname);
                req.setAttribute("email", email);
                req.setAttribute("about", about);
                req.setAttribute("message", "Passwords must match");
            }

        } else {
            req.setAttribute("name", fullname);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("password2", password2);
            req.setAttribute("about", about);
            req.setAttribute("message", "Fill all fields, please");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/page_view.jsp").forward(req, resp);
    }
}
