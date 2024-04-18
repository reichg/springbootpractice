package com.evolutionaryeyes.springpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/*
 - @Entity for Spring
 - @Id used for primary key and needed in the Jpa extension
 - @GeneratedValue used for primary key auto generation
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank(message = "Department name is required")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
