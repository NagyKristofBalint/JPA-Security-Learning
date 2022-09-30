package edu.nagy.jpa_security_learning;

import edu.nagy.jpa_security_learning.model.Course;
import edu.nagy.jpa_security_learning.model.Teacher;
import edu.nagy.jpa_security_learning.repository.CourseDAO;
import edu.nagy.jpa_security_learning.repository.TeacherDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class JpaSecurityLearningApplicationTests {
    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    CourseDAO courseDAO;

    @Test
    @Transactional
    void asd() {
        Teacher teacher = new Teacher(4, new LinkedList<>());
        List<Course> courses = new LinkedList<>();
        //courses.add(new Course("roman", 100));
    }

}