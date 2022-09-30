package edu.nagy.jpa_security_learning.service.impl;

import edu.nagy.jpa_security_learning.model.Course;
import edu.nagy.jpa_security_learning.repository.CourseDAO;
import edu.nagy.jpa_security_learning.repository.CourseMaterialDAO;
import edu.nagy.jpa_security_learning.service.CourseService;
import edu.nagy.jpa_security_learning.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CourseMaterialDAO courseMaterialDAO;

    @Override
    public Course create(Course course) {
        try {
            return courseDAO.save(course);
        } catch (PersistenceException e) {
            log.error("Failed to create Course with id: {}", course.getId());
            throw new ServiceException("Failed to create Course with id: " + course.getId(), e);
        }
    }

    @Override
    public void addCourseMaterialToCourse(Long courseId, Long courseMaterialId) {
        try{
            Course course = courseDAO.findById(Math.toIntExact(courseId)).orElse(null);
            course.setCourseMaterial(courseMaterialDAO.findById(Math.toIntExact(courseMaterialId)).orElse(null));
            courseDAO.save(course);
        } catch (PersistenceException e) {
            log.error("Failed to add CourseMaterial with id: {} to Course with id: {}", courseMaterialId, courseId);
            throw new ServiceException("Failed to add CourseMaterial with id: " + courseMaterialId + " to Course with id: " + courseId, e);
        }
    }

    @Override
    public Course getById(Long courseId) {
        try {
            return courseDAO.findById(Math.toIntExact(courseId)).orElse(null);
        } catch (PersistenceException e) {
            log.error("Failed to get Course with id: {}", courseId);
            throw new ServiceException("Failed to get Course with id: " + courseId, e);
        }
    }

    @Override
    public boolean exists(Long courseId) {
        try{
            return courseDAO.findById(Math.toIntExact(courseId)).isPresent();
        } catch (PersistenceException e) {
            log.error("Failed to check if Course with id: {} exists", courseId);
            throw new ServiceException("Failed to check if Course with id: " + courseId + " exists", e);
        }
    }
}
