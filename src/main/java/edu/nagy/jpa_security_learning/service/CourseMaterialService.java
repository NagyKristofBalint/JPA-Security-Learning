package edu.nagy.jpa_security_learning.service;

import edu.nagy.jpa_security_learning.model.CourseMaterial;
import org.springframework.stereotype.Service;

public interface CourseMaterialService {
    CourseMaterial create(CourseMaterial courseMaterial);
    CourseMaterial getById(Long courseMaterialId);
    boolean exists(Long courseMaterialId);
}
