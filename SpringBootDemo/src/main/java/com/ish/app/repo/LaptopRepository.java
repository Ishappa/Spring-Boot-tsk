package com.ish.app.repo;

import com.ish.app.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop lap){
        System.out.println("Repository save method called");
    }
}
