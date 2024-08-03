package com.ish.Spring_Data_Jpa_1;

import com.ish.Spring_Data_Jpa_1.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpa1Application.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setName("Ish");
		s1.setMarks(78);
		s1.setRollNo(101);

		s2.setName("Manoj");
		s2.setMarks(75);
		s2.setRollNo(102);

		s3.setName("Dan");
		s3.setMarks(80);
		s3.setRollNo(103);

//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

		System.out.println(repo.findAll());// to fetch and display all rows from table.
//		System.out.println(repo.findById(101));// display based on Id.

//		----------------------------------------

//		System.out.println(repo.findByName("Ish"));
//		System.out.println(repo.findByMarks(80));
//		System.out.println(repo.findByMarksGreaterThan(70));

		// update---------
//		repo.save(s1);


//	Delete ----------
//		repo.delete(s3);


	}

}
