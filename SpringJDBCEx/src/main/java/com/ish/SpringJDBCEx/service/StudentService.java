package com.ish.SpringJDBCEx.service;

import com.ish.SpringJDBCEx.model.Student;
import com.ish.SpringJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student s1){
        studentRepo.save(s1);
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }
}
