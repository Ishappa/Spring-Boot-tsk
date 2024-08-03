package com.ish.Spring_Data_Jpa_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")//we can work with multiple Objects
@Entity
public class Student {

    @Id
    private int rollNo;
    private String name;
    private int marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
