package edu.nagy.jpa_security_learning.api.dto.incoming;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CourseCreationDTO {
    @NotNull
    String name;

    @NotNull
    String maxNumberOfStudents;
}
