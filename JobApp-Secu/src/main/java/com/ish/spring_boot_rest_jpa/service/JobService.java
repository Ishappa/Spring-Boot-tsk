package com.ish.spring_boot_rest_jpa.service;

import com.ish.spring_boot_rest_jpa.model.JobPost;
import com.ish.spring_boot_rest_jpa.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
    }
    public JobPost addJob(JobPost job){
        return jobRepo.save(job);
    }

    // we have to make it specify optional

//    public JobPost getJob(int postId) {
//        return jobRepo.findById(postId).orElse(new JobPost());
//    }

//    public JobPost getJob(int postId) {
//        Optional<JobPost> jobPost = jobRepo.findById(postId);
//        return jobPost.orElse(null); // Return null if job post is not found
//    }

    // we can avoid optional and use jus return condition null
    public JobPost getJob(int postId) {
        return jobRepo.findById(postId).orElse(null);
    }


    public void updateJob(JobPost jobPost){
         jobRepo.save(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteById(jobId);
    }

    public void load(){
         List<JobPost> jobs = new ArrayList<>(List.of(

                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java",
                        2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")),

                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                new JobPost(4, "Data-Base Developer", "Strong background in SQl and MySql", 6,
                        List.of("SQL", "MYSQL")),

                new JobPost(5, "Android Developer", "Strong background in Java and Kotlin", 5,
                        List.of("Java", "Kotlin"))

        ));

         jobRepo.saveAll(jobs);

    }

    public List<JobPost> searchKeyword(String keyword){
       return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }


}
