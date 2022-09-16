package edu.nagy.jpa_security_learning.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Courses")
public class Course extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer numberOfMaxStudents;
}
