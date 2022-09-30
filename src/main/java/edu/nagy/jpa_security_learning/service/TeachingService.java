package edu.nagy.jpa_security_learning.service;

import edu.nagy.jpa_security_learning.model.Teaching;
import org.springframework.stereotype.Service;

@Service
public interface TeachingService {
    Teaching create(Teaching teaching);
    void update(Teaching teaching);
    void delete(Long teachingId);
    Teaching getById(Long teachingId);
}
