package com.ish;

import org.springframework.stereotype.Component;

//component annotation it will say to spring to manage the objects
@Component("lap")
//@Scope("prototype")
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptop object is created");
    }

    public void compile(){
        System.out.println("Lap code Compiling");
    }
}
