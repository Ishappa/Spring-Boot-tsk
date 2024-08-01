package org.ish;

import org.ish.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 -> beans are the objects and these are managed by the springs.
ex: spring.xml (get definition by browsing spring xml config)
 */
public class App 
{
    public static void main( String[] args )
    {
        //-------------------using java configuration------------------------


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Desktop dt = context.getBean(Desktop.class);

//      1.  if we want get based on name we can use method of the name
//          Desktop dt = context.getBean("desktop1", Desktop.class);
//          dt.compile();
//          Desktop dt1 = context.getBean(Desktop.class);
//          dt1.compile();

          Alien obj1 = context.getBean(Alien.class);
          System.out.println(obj1.getAge());
          obj1.code();


        //----------------- using xml config -----------------------------

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");//it will create a object -> ApplicationContext
//        Alien a1 = (Alien)context.getBean("alien1");// it is calling the object
//        //        a1.code();
//        a1.age=10;
//        System.out.println(a1.age);
//
//
//        Alien a2 = (Alien)context.getBean("alien1");// it is calling the object
//        //        a2.code();
//        System.out.println(a2.age);

//        Alien a1 = (Alien) context.getBean("alien1");
////        a1.setAge(10); manually setting age
//        System.out.println(a1.getAge());
//        a1.code();
//
////        Alien a3 = context.getBean("alien1",Alien.class);
////        instead og casting we can speciafy the classname.class
//        Alien a3 = context.getBean(Alien.class);
//
//        Computer c = context.getBean(Computer.class);



    }

}
