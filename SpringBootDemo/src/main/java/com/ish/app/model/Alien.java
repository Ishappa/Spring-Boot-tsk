package com.ish.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("28")
    private int age;
//    @Autowired
    private Computer com ;

    public void code(){
        com.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")// i have used @Primary to Desktop class but in qualifier i have mention laptop class 1st priority will be laptop class
    public void setCom(Computer com) {
        this.com = com;
    }
}
