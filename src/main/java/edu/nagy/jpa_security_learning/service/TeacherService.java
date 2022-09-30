package edu.nagy.jpa_security_learning.service;

import edu.nagy.jpa_security_learning.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    Teacher create(Teacher teacher);
    void addCourseToTeacher(Long teacherId, Long courseId);
    Teacher getById(Long teacherId);
}
