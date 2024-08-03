package com.ish.spring_boot_rest_jpa.repo;

import com.ish.spring_boot_rest_jpa.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String Desc);

}
//    private List<JobPost> jobs = new ArrayList<>(List.of(
//
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java",
//                    2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                    3, List.of("HTML", "CSS", "JavaScript", "React")),
//
//            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                    List.of("Python", "Machine Learning", "Data Analysis")),
//
//            new JobPost(4, "Data-Base Developer", "Strong background in SQl and MySql", 6,
//                    List.of("SQL", "MYSQL")),
//
//            new JobPost(5, "Android Developer", "Strong background in Java and Kotlin", 5,
//                    List.of("Java", "Kotlin"))
//
//    ));
//
//
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    public boolean addJob(JobPost job){
//        for (JobPost job1:jobs){
//            if (job1.getPostId()==job.getPostId()){
//                return false;
//            }
//        }
//        jobs.add(job);
//        System.out.println(jobs);
//        return true;
//
//    }
//
//    public JobPost getJob(int postId) {
//        for (JobPost post:jobs){
//            if (post.getPostId()==postId){
//                return post;
//            }
//        }
//        return null;
//    }
//
//
//    public boolean updateJob(JobPost jobPost){
//        for (JobPost posts:jobs){
//            if (posts.getPostId()==jobPost.getPostId()){
//                posts.setPostDesc(jobPost.getPostDesc());
//                posts.setPostProfile(jobPost.getPostProfile());
//                posts.setPostTechStack(jobPost.getPostTechStack());
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean deleteJob(int jobId) {
//        for (JobPost jobPosts:jobs){
//            if (jobPosts.getPostId()==jobId){
//                jobs.remove(jobPosts);
//                return true;
//
//            }
//        }
//        return false;
//    }
