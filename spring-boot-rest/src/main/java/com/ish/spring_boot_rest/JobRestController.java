package com.ish.spring_boot_rest;

import com.ish.spring_boot_rest.model.JobPost;
import com.ish.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {

    @Autowired
    private JobService service;

    //In Rest this is major difference of returning data instead of returning viewName
    //    @ResponseBody or use @RestController on top of class
//    @GetMapping(value = "jobPosts" , produces = "application/xml")
    @GetMapping(value = "jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    //getting job based on ID
    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){
        return service.getJob(jobId);
    }

//    @PostMapping("/jobPost")
//    public ResponseEntity<String> addJob(@RequestBody JobPost jobPost) {
//        service.addJob(jobPost);
//        JobPost savedJobPost = service.getJob(jobPost.getPostId());
//        String successMessage = "Job added successfully with ID: " + savedJobPost.getPostId();
//        return ResponseEntity.ok(successMessage);
//    }


    //when you want send or request data to server we need @RequestBody
//    @PostMapping(value = "jobPost", consumes = "application/json")
    @PostMapping("jobPost")
    public String addJob(@RequestBody JobPost jobPost) {
       boolean result = service.addJob(jobPost);
//        return service.getJob(jobPost.getPostId());// adding obj and fetching obj from server or source.
        if (result){
            return "job added successfully";
        }
        return "Job Already Exist";
    }

    @PutMapping("jobPost")
    public String updateJob(@RequestBody JobPost jobPost){
          boolean result = service.updateJob(jobPost);
          JobPost updatedJob = service.getJob(jobPost.getPostId());
          if (result){
              return "Job Updated :"+ updatedJob;
          }
            return "Job Updated failed might Id of Job is not Exist";
        }

    @DeleteMapping("jobPost/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId) {
        boolean result = service.deleteJob(jobId);
        if (result) {
            return "Job Deleted";
        }
        return "Job not exist for delete";
    }
    }
