package com.ish.spring_data_rest1.repo;

import com.ish.spring_data_rest1.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

}
