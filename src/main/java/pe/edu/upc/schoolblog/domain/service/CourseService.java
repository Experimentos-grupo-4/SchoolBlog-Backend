package pe.edu.upc.schoolblog.domain.service;

import pe.edu.upc.schoolblog.domain.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> fetchAll();
    Optional<Course> fetchById(Integer id);
    Course save(Course course);
    Course update(Course course);
    boolean deleteById(Integer id);
}
