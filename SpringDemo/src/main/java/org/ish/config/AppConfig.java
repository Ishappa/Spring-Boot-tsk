package org.ish.config;

import org.ish.Alien;
import org.ish.Computer;
import org.ish.Desktop;
import org.ish.Laptop;
import org.springframework.context.annotation.*;

@Configuration
//no need bean obj for if we are using component sterotype annotation ex: @compone and @Autowired etc
@ComponentScan("org.ish")
public class AppConfig {
//    note: by default all beans are single ton means its return only once a obj whenevr requests comes.
//    when you use prototype it will return or create a object for each request.
//we can use multiple name or single for getting specific bean for creating objects
//    @Bean(name = {"com3","desktop"})

//    @Bean
//    public Alien alien(Computer com){
//        Alien obj = new Alien();
//        obj.setAge(28);
//        obj.setCom(com);
//        return obj;
//    }
//    @Bean
////    @Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
