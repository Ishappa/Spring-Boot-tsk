package org.ish;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary//if we not mention any class in qualifier default it will call this
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("Desktop obj is created");
    }
    @Override
    public void compile(){
        System.out.println("Desktop Compiling");
    }

}
