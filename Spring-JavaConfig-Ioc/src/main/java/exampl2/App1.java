package exampl2;

import exampl2.configr.App1Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App1Config.class);
        Student s1 = context.getBean(Student.class);
        s1.disp();
    }
}
