package edu.nagy.jpa_security_learning.service.impl;

import edu.nagy.jpa_security_learning.model.CourseMaterial;
import edu.nagy.jpa_security_learning.repository.CourseMaterialDAO;
import edu.nagy.jpa_security_learning.service.CourseMaterialService;
import edu.nagy.jpa_security_learning.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Slf4j
@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {
    @Autowired
    CourseMaterialDAO courseMaterialDAO;

    @Override
    public CourseMaterial create(CourseMaterial courseMaterial) {
        try {
            return courseMaterialDAO.save(courseMaterial);
        } catch (PersistenceException e) {
            log.error("Failed to create CourseMaterial with id: {}", courseMaterial.getId());
            throw new ServiceException("Failed to create CourseMaterial with id: " + courseMaterial.getId(), e);
        }
    }

    @Override
    public CourseMaterial getById(Long courseMaterialId) {
        try {
            return courseMaterialDAO.findById(Math.toIntExact(courseMaterialId)).orElse(null);
        } catch (PersistenceException e) {
            log.error("Failed to get CourseMaterial with id: {}", courseMaterialId);
            throw new ServiceException("Failed to get CourseMaterial with id: " + courseMaterialId, e);
        }
    }

    @Override
    public boolean exists(Long courseMaterialId) {
        try{
            return courseMaterialDAO.existsById(Math.toIntExact(courseMaterialId));
        } catch (PersistenceException e) {
            log.error("Failed to check if CourseMaterial with id: {} exists", courseMaterialId);
            throw new ServiceException("Failed to check if CourseMaterial with id: " + courseMaterialId + " exists", e);
        }
    }
}
