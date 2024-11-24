package com.example.school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class School {
    @Id
    private Integer id;
    @NotNull
    private String name;

    @NotNull
    private String email;

}