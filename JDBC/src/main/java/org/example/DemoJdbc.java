package org.example;
import java.sql.*;
public class DemoJdbc {
    public static void main(String[] args) throws Exception {
       /*
       import packages
       load and register
       create connection/ establish
       create statement
       execute statement
       process the results
       close
        */
        String url="jdbc:mysql://localhost:3306/demo";
        String uname="root";
        String pass="root";
        String sql= "select name from user where id=1";
//        String sql= "select * from user";


//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,uname,pass);
        System.out.println("Established the connection");
        Statement statement = connection.createStatement();
        ResultSet result =  statement.executeQuery(sql);
        result.next();// it will go to the row by row in table

        String name = result.getString("name");// mention the column name
        System.out.println("name is :"+name);
        connection.close();
        System.out.println("connection closed");





    }
}
