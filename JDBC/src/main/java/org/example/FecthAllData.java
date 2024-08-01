package org.example;
import java.sql.*;
public class FecthAllData {
    public static void main(String[] args) throws Exception {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
        Statement statement = connection.createStatement();
        System.out.println("established the connection");
        ResultSet resultSet = statement.executeQuery("Select * from student");
      while(resultSet.next()) {
          System.out.print(resultSet.getInt(1)+" - ");
          System.out.print(resultSet.getString(2)+ " - ");
          System.out.println(resultSet.getInt(3));


      }
      connection.close();
        System.out.println("Connection closed");
    }
}
