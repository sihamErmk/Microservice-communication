package com.example.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Student {
    @Id
    private Integer id;
    private  String firstname;
    private String lastname;
    private String email;

    // now, establish the relation between  the student and the  school
    private  Integer schoolId;


}
