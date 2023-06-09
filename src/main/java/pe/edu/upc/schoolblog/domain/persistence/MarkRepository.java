package pe.edu.upc.schoolblog.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.schoolblog.domain.entity.Mark;
import pe.edu.upc.schoolblog.domain.entity.Student;
import pe.edu.upc.schoolblog.domain.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> findByStudentId(Integer studentId);

    List<Mark> findByTeacherId(Integer teacherId);

    Optional<Mark> findByEvaluationId(Integer evaluationId);

}
