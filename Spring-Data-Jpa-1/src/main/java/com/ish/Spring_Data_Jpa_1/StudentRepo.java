package com.ish.Spring_Data_Jpa_1;

import com.ish.Spring_Data_Jpa_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

//    @Query("Select s from Student s where s.name = ?1")//--> using alias for fetch data from obj in db.
//    --> without query also will work based on method name few methods are provided by repo
//    --> example:
//              1.findByName() --> findBy this is important
//              2. findByMarks() and findByMarksGreaterThan()
List<Student> findByName(String name);

List<Student> findByMarks(int marks);

List<Student> findByMarksGreaterThan(int marks);
}
