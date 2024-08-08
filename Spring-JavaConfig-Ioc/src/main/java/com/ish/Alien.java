package com.ish;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("23")
    private int age;

//    @Autowired
//    @Qualifier("lap")
    // better way we can use @Autowired to where will be setter inject
    private Computer com;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
//        System.out.println("Setter method Called");
        this.age = age;
    }

    public Alien(){
        System.out.println("Alien obj is created");
    }
//    public Alien(int age, Laptop lap){
//        System.out.println("Alien Object Created");
//        this.age=age;
//        this.lap=lap;
//
//    }

//    public Alien(int age, Computer com){
//        System.out.println("Alien Object Created");
//        this.age=age;
//        this.com=com;
//
//    }


//    public Laptop getLap() {
//        return lap;
//    }
//
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("lap")//i used @primary for Desktop but still calling lap implementation priority more for this
//  @Qualifier("desktop")// we can use class name lowercase
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
       System.out.println("coding");
       com.compile();
   }
}
