package pe.edu.upc.schoolblog.domain.service;

import pe.edu.upc.schoolblog.domain.entity.Mark;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    List<Mark> fetchAll();
    Optional<Mark> fetchById (Integer id);

    Mark save (Mark mark);

    Mark update (Mark mark);

    Boolean deleteById (Integer id);
}
