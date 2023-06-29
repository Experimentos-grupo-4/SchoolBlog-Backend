package pe.edu.upc.schoolblog.marks.domain.service;

import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    List<Mark> fetchAll();
    Optional<Mark> fetchById (Integer id);

    List<Mark> fetchByStudent(Student student);

    Mark save (Mark mark);

    Mark update (Mark mark);

    Boolean deleteById (Integer id);
}
