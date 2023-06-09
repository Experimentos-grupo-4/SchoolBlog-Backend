package pe.edu.upc.schoolblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.domain.entity.Course;
import pe.edu.upc.schoolblog.domain.persistence.CourseRepository;
import pe.edu.upc.schoolblog.domain.service.CourseService;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

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
            return Optional.empty();
        }
    }

    @Override
    public Course save(Course course) {
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
