package com.ish.spring_boot_rest.service;

import com.ish.spring_boot_rest.model.JobPost;
import com.ish.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }
    public boolean addJob(JobPost job){
        return jobRepo.addJob(job);
    }

    public JobPost getJob(int postId) {
        return jobRepo.getJob(postId);
    }

    public boolean updateJob(JobPost jobPost){
        return jobRepo.updateJob(jobPost);
    }

    public boolean deleteJob(int jobId) {
       return jobRepo.deleteJob(jobId);
    }
}
