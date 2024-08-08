package exampl2;

import org.springframework.stereotype.Component;

@Component
public class StudentImpl implements Student{
    @Override
    public void disp(){
        System.out.println("Implemented Student");
    }
}
