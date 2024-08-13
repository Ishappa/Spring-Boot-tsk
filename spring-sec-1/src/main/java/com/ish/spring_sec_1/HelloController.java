package com.ish.spring_sec_1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @GetMapping("/home")
//    public String message(){
//        return "Hello world";
//    }

//    get session id for jus for practice and checking for each url once we logged in
@GetMapping("/")
public String message(HttpServletRequest request){
    return "Hello world : Session Id "+request.getSession().getId();
}
    @GetMapping("/about")
    public String about(HttpServletRequest request){
    return "This is ABout : Session Id "+request.getSession().getId();
    }
}
