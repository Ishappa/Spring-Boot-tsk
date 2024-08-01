package com.ish.SpringJDBCEx.repo;

import com.ish.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s1){
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbcTemplate.update(sql, s1.getRollNo(), s1.getName(), s1.getMarks());

        System.out.println(rows +" : effected");
    }

    public List<Student> findAll(){
        String sql = "select * from student";

//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//                Student s1 = new Student();
//                s1.setRollNo(rs.getInt("rollno"));
//                s1.setName(rs.getString("name"));
//                s1.setMarks(rs.getInt("marks"));
//                return s1;
//            }
//        };

        // RowMapper is a functional interface because using lambda expression
        //using RowMapper we can fetch the data from table.
        RowMapper<Student> mapper = (rs,rowNum) ->{
                Student s1 = new Student();
                s1.setRollNo(rs.getInt("rollno"));
                s1.setName(rs.getString("name"));
                s1.setMarks(rs.getInt("marks"));
                return s1;
        };
        return jdbcTemplate.query(sql, mapper);
    }

}
