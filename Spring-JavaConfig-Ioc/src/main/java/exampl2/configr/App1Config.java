package exampl2.configr;

import exampl2.Student;
import exampl2.StudentImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("exampl2")
public class App1Config {
    @Bean
    public StudentImpl student(){
        return new StudentImpl();
    }
}
