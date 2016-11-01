package ru.itis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by UseR7 on 10.10.2016.
 */
public class DatabaseUtil {
    private final static String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String CONNECTION_URI = "jdbc:sqlserver://localhost:1433;DatabaseName=myDatabase";
    private final static String LOGIN = "admin";
    private final static String PASSWORD = "gulnaz1971bulat1997";
    private static Connection conn;

    public static Connection getConn(){
        if(conn==null){
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    return conn;
    }
}
