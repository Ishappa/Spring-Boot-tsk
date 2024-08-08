package com.ish;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary//if we not mention any class in qualifier only it will call this class
//@Scope("prototype")
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("Desktop obj is created");
    }
    @Override
    public void compile(){
        System.out.println("Desktop Compiling");
    }

}
