package edu.nagy.jpa_security_learning.service;

import edu.nagy.jpa_security_learning.model.Course;
import org.springframework.stereotype.Service;

public interface CourseService {
    Course create(Course course);
    void addCourseMaterialToCourse(Long courseId, Long courseMaterialId);
    Course getById(Long courseId);
    boolean exists(Long courseId);
}
