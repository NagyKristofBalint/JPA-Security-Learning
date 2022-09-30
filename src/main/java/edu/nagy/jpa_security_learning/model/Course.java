package edu.nagy.jpa_security_learning.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Courses")
public class Course extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private Integer numberOfMaxStudents;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private CourseMaterial courseMaterial;
}