package edu.nagy.jpa_security_learning.repository;

import edu.nagy.jpa_security_learning.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
}