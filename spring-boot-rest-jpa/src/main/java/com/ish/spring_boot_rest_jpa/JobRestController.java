package com.ish.spring_boot_rest_jpa;

import com.ish.spring_boot_rest_jpa.model.JobPost;
import com.ish.spring_boot_rest_jpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(value = "jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    //getting job based on ID
    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId) {
        return service.getJob(jobId);
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){

        return service.searchKeyword(keyword);
    }

    @PostMapping("jobPost")
    public String addJob(@RequestBody JobPost jobPost) {
        JobPost existingJobPost = service.getJob(jobPost.getPostId());

        if (existingJobPost == null) { // Check if job post does not already exist
            service.addJob(jobPost); // Save the new job post
            return "Added Job is: " + jobPost;
        }
        return "Not added, job with the same ID already exists.";
    }

    @PutMapping("jobPost")
    public String updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        JobPost updatedJob = service.getJob(jobPost.getPostId());
        return "Job Updated :" + updatedJob;
    }

    @DeleteMapping("jobPost/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId) {
        service.deleteJob(jobId);
        return "Job Deleted";
    }

    @GetMapping("load")
    public String dataLoad(){
        service.load();
        return "Data Loaded SuccessFully";
    }
}
