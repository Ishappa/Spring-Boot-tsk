package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoCRUD {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String uname = "root";
        String pass = "root";

        int id = 6;
        String name = "sankar";
        int marks = 89;

        String sqlQuerry = "insert into student values("+id+","+"'"+name+"'"+","+ marks+")";

//        String sqlQuerry = "insert into student values(5,'akshay',56)";// create or insert
//        String sqlQuerry = "update student set name='kudari' where id=5";// update
//        String sqlQuerry = "delete from student where id=5";// delete


        Connection connection = DriverManager.getConnection(url,uname,pass);
        System.out.println("Established the Connection");
        Statement statement = connection.createStatement();
        statement.execute(sqlQuerry);

        connection.close();
        System.out.println("connection closed");
        

    }
}
