package com.ish.JobApp.service;

import com.ish.JobApp.model.JobPost;
import com.ish.JobApp.repo.JobRepo;
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
    public void addJob(JobPost job){
        jobRepo.addJob(job);

    }

}
