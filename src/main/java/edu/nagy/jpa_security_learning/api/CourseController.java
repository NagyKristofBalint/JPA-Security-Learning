package edu.nagy.jpa_security_learning.api;

import edu.nagy.jpa_security_learning.api.dto.incoming.CourseCreationDTO;
import edu.nagy.jpa_security_learning.api.errorhandling.ApiException;
import edu.nagy.jpa_security_learning.api.errorhandling.BadRequestException;
import edu.nagy.jpa_security_learning.api.errorhandling.NotFoundException;
import edu.nagy.jpa_security_learning.model.Course;
import edu.nagy.jpa_security_learning.service.CourseMaterialService;
import edu.nagy.jpa_security_learning.service.CourseService;
import edu.nagy.jpa_security_learning.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api/courses")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseMaterialService courseMaterialService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody @Valid CourseCreationDTO courseCreationDTO) {
        try {
            Course course = modelMapper.map(courseCreationDTO, Course.class);
            return courseService.create(course);
        } catch (ServiceException e) {
            log.error("Course creation failed", e);
            throw new ApiException("Course creation failed", e);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Course getCourse(@PathVariable("id") Long id) {
        try {
            Course course = courseService.getById(id);
            if(course == null) {
                throw new NotFoundException();
            }
            return course;
        } catch (ServiceException e) {
            log.error("Course retrieval failed", e);
            throw new ApiException("Course retrieval failed", e);
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCourseMaterialToCourse(@PathVariable("id") Long id, @Param("courseMaterialId") Long courseMaterialId) {
        if(courseMaterialId == null) {
            throw new BadRequestException("Course material id is required");
        }
        if(!courseService.exists(id) || !courseMaterialService.exists(courseMaterialId)) {
            throw new NotFoundException();
        }
        try {
            courseService.addCourseMaterialToCourse(id, courseMaterialId);
        } catch (ServiceException e) {
            log.error("Course update failed", e);
            throw new ApiException("Course update failed", e);
        }
    }
}
