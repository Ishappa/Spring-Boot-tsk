package com.ish.spring_data_rest1.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;

    @ElementCollection
    private List<String> postTechStack;
}
