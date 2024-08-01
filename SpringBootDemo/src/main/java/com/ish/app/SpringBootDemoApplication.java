package com.ish.app;

import com.ish.app.model.Alien;
import com.ish.app.model.Laptop;
import com.ish.app.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class,args);
		LaptopService service = context.getBean(LaptopService.class);
		Laptop lap = context.getBean(Laptop.class);

		service.addLaptop(lap);



	//		Alien a1 = context.getBean(Alien.class);
//		System.out.println("Age is : "+a1.getAge());
//		a1.code();



	}

}
