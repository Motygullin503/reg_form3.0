package ru.itis.repositories;

import ru.itis.entities.Themes;
import ru.itis.entities.User;
import ru.itis.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UseR7 on 10.10.2016.
 */
public class SQLUserRepository {
private static String email;
    public static void add(User user) {
        Connection conn = DatabaseUtil.getConn();
        try {
            PreparedStatement st = conn.prepareStatement("INSERT  INTO Users VALUES (?,?,?,?,?,?,?,?)");
            st.setString(1, user.getName());
            st.setString(2, email = user.getEmail());
            st.setString(3, user.getPassword());
            st.setString(4, user.getGender());
            st.setString(5, user.getCity());
            st.setString(6, user.getAbout());
            st.setString(7, user.getSubscription());
            st.setString(8, user.getIsAdmin());
            st.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void addTheme(Themes theme) {
        Connection conn = DatabaseUtil.getConn();
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO Themes VALUES (?,?,?,?,?,?)");
            st.setInt(1, SQLUserRepository.getId(email));
            st.setString(2, theme.getName());
            st.setString(3, theme.getCity());
            st.setString(4, theme.getSport());
            st.setString(5, theme.getMusic());
            st.setString(6, theme.getCategory());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getId(String email1) {
        Connection conn = DatabaseUtil.getConn();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(email1)) {
                    int id = resultSet.getInt("user_id");
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getUsername(int id) {
        Connection conn = DatabaseUtil.getConn();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                if (resultSet.getInt("user_id")==id) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getPreferences(int id) {
        List list = new ArrayList();
        Connection conn = DatabaseUtil.getConn();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM Themes");
            while (resultSet.next()) {
                if (resultSet.getInt("user_id")==id) {
                    list.add(resultSet.getString("team_name"));
                    list.add(resultSet.getString("sport"));
                    list.add(resultSet.getString("music"));
                    list.add(resultSet.getString("category"));
                    return list;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> getAll() {
        List<User> users = new ArrayList<User>();
        Connection conn = DatabaseUtil.getConn();
        try {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("name"),
                        resultSet.getString("email"),
                        "salt" + resultSet.getString("password"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getString("about"),
                        resultSet.getString("sub"),
                        resultSet.getString("is_admin")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
