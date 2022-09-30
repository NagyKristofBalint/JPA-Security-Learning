package edu.nagy.jpa_security_learning.repository;

import edu.nagy.jpa_security_learning.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {
}
