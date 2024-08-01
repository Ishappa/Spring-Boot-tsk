package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoPreStat {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String uname = "root";
        String pass = "root";

        int id = 8;
        String name = "gani";
        int marks = 35;

        String sqlQuery = "insert into student values(?,?,?)";

        Connection connection = DriverManager.getConnection(url,uname,pass);
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,marks);

        ps.execute();

        System.out.println("query executed successfully");


    }
}
