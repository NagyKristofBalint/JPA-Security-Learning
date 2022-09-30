package edu.nagy.jpa_security_learning.repository;

import edu.nagy.jpa_security_learning.model.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingDAO extends JpaRepository<Teaching, Long> {
}
