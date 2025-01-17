package com.ish.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
//------------1st--------------
//    @RequestMapping("add")
//    public String add(HttpServletRequest request, HttpSession session){
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        int result = num1+num2;
////        System.out.println(result);
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

//    ------------2nd---------------
    //instead using HttpSession we can use Model
//    @RequestMapping("add")
//    public String add(@RequestParam("num1")int num1, @RequestParam("num2")int num2, Model model){
//        int result = num1+num2;
//        model.addAttribute("result", result);
//        return "result";
//    }

//    --------------------3rd------------------
    // instead using Model we can use ModelAndView
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1")int num1, @RequestParam("num2")int num2, ModelAndView mv){
        int resultData = num1+num2;
        mv.addObject("result", resultData);
        mv.setViewName("result");

        return mv;
    }
}
