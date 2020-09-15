quip  package com.example.JBS.model;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class ReadPost {

    private final String url = "jdbc:postgresql://localhost:5432/recall";
    private final String user = "postgres";
    private final String password = "admin";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void createItem(String brand, String company, String reason, String pd, String url, String date, int id) {
        try {
            PreparedStatement st = connect().prepareStatement("INSERT INTO recall (id, brand, company, reason, pd, url, date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, id);
            st.setString(2, brand);
            st.setString(3, company);
            st.setString(4, reason);
            st.setString(5, pd);
            st.setString(6, url);
            st.setString(7, date);
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        ReadPost database = new ReadPost();
        database.connect();
        List<Recall> tasks = XMLUtil.retrieveXMLData();
        for(Recall task: tasks) {
            if (task != null) {
                database.createItem(task.getBrand().trim(), task.getCompany().trim(), task.getReason().trim(), task.getPd().trim(), task.getUrl().trim(), task.getDate().trim(), 0);
            }
        }
    }
}