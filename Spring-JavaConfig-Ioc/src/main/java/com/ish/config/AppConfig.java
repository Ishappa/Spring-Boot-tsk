package com.ish.config;

import com.ish.Alien;
import com.ish.Computer;
import com.ish.Desktop;
import com.ish.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.ish")// mention base package for find all @compo
public class AppConfig {


//refr v 155
//-----------by using @Component to all classes we no need to create obj manually that's why commended all code and use @ComponentScan top of AppConfig----------------


//    @Bean
//    public Alien alien( Computer com){ //@Qualifier("desktop")
//        Alien obj = new Alien();
//        obj.setAge(45);
//        obj.setCom(com);
//        return obj;
//    }
//
////    @Bean(name = "desk")
//    @Bean
////    @Scope("prototype") //make obj can create multiple
//    public Desktop desktop(){   //method name consider as a default bean name
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }

}
