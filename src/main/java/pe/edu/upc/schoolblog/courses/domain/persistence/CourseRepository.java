package pe.edu.upc.schoolblog.courses.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {
    Optional<Course> findByName(String name);
}
