package com.ish.app.service;
import com.ish.app.model.Laptop;
import com.ish.app.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository lapRepo;

    public void addLaptop(Laptop lap){
       lapRepo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
