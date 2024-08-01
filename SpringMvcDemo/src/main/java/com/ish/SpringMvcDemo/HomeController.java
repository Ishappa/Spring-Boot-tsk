package com.ish.SpringMvcDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("home method called");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1")int num1, @RequestParam("num2")int num2, ModelAndView mv){
        int resultData = num1+num2;
        mv.addObject("result", resultData);
        mv.setViewName("result");

        return mv;
    }
}
