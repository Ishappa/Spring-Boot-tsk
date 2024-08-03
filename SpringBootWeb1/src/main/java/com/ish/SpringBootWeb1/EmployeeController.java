package com.ish.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @ModelAttribute("role")
    public String empRole(){
        return "Java";
    }

    @RequestMapping("/emp")
    public String home(){
        System.out.println("emp method called");
        return "employeeInfo";
    }
//1. normal way with using attribute and modelveiw --------------------
//    @RequestMapping("addEmployee")
//    public ModelAndView addEmployee(@RequestParam("eid")int eid, @RequestParam("ename")String ename, ModelAndView modelAndView){
//
//        Employee employee = new Employee();
//        employee.setEid(eid);
//        employee.setEname(ename);
//        modelAndView.addObject("empRes", employee);
//        modelAndView.setViewName("empResult");
//        return modelAndView;
//    }


//2. simple way we can get obj derails on page--------------------
//    @RequestMapping("addEmployee")
//    public String addEmployee(@ModelAttribute("employee1") Employee employee){
//        return "empResult";
//    }


//  3.  @ModelAttribute("employee1") is optional we can use method ref name in jsp we can get details----------------
    @RequestMapping("addEmployee")
    public String addEmployee(Employee employee){
        return "empResult"; 
    }
}
