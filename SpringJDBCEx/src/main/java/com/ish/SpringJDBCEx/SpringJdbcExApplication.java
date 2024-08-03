package com.ish.SpringJDBCEx;

import com.ish.SpringJDBCEx.model.Student;
import com.ish.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

	Student s1 = context.getBean(Student.class);
	s1.setRollNo(106);
	s1.setName("ish");
	s1.setMarks(85);

		StudentService studentService = context.getBean(StudentService.class);
	    studentService.addStudent(s1);
		List<Student> students = studentService.getStudents();
		System.out.println(students);
	}
}
