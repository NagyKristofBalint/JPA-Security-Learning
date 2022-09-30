package edu.nagy.jpa_security_learning.api;

import edu.nagy.jpa_security_learning.api.dto.incoming.CourseMaterialCreationDTO;
import edu.nagy.jpa_security_learning.api.errorhandling.ApiException;
import edu.nagy.jpa_security_learning.api.errorhandling.NotFoundException;
import edu.nagy.jpa_security_learning.model.CourseMaterial;
import edu.nagy.jpa_security_learning.service.CourseMaterialService;
import edu.nagy.jpa_security_learning.service.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/course-materials")
@RestController
public class CourseMaterialController {
    @Autowired
    private CourseMaterialService courseMaterialService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CourseMaterial createCourseMaterial(@RequestBody CourseMaterialCreationDTO courseMaterialCreationDTO) {
        try {
            CourseMaterial courseMaterial = modelMapper.map(courseMaterialCreationDTO, CourseMaterial.class);
            return courseMaterialService.create(courseMaterial);
        } catch (ServiceException e) {
            log.error("Course material creation failed", e);
            throw new ApiException("Course material creation failed", e);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CourseMaterial getCourseMaterial(@PathVariable("id") Long id) {
        try {
            CourseMaterial courseMaterial = courseMaterialService.getById(id);
            if(courseMaterial == null) {
                throw new NotFoundException();
            }
            return courseMaterial;
        } catch (ServiceException e) {
            log.error("Course material retrieval failed", e);
            throw new ApiException("Course material retrieval failed", e);
        }
    }
}
