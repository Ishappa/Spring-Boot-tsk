package com.ish.JobApp;

import com.ish.JobApp.model.JobPost;
import com.ish.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;


//    @RequestMapping({"/", "home"})
@GetMapping({"/", "home"})
    public String home(){
        return "home";
    }

//    @RequestMapping("addjob")
@GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
       service.addJob(jobPost);
        return "success";
    }

//    @GetMapping("viewalljobs")
//    public ModelAndView viewJobs(ModelAndView mv){
//    List<JobPost> jobs = service.getAllJobs();
//    mv.addObject("jobPosts",jobs);
//    mv.setViewName("viewalljobs");
//    return mv;
//    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }
}
