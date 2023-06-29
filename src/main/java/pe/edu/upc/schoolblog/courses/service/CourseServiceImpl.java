package pe.edu.upc.schoolblog.courses.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.domain.persistence.CourseRepository;
import pe.edu.upc.schoolblog.courses.domain.service.CourseService;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Course> fetchAll() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Course> fetchById(Integer id) {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id);
        } else {
            throw new ResourceNotFoundException(Constant.COURSE_ENTITY, id);
        }
    }

    @Override
    public Course save(Course course) {
        Set<ConstraintViolation<Course>>
                violations = validator.validate(course);

        if (!violations.isEmpty()){
            throw new ResourceValidationException(violations);
        }

        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if(courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
