package com.ish;

import com.ish.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien a1 = context.getBean(Alien.class);
        System.out.println(a1.getAge());
        a1.code();

        Desktop dt = context.getBean(Desktop.class);
        dt.compile();


    }
}
