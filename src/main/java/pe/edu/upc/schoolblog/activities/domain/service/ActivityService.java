package pe.edu.upc.schoolblog.activities.domain.service;

import pe.edu.upc.schoolblog.activities.domain.model.entity.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> fetchAll();
    Optional<Activity> fetchById(Integer id);
    Activity save(Activity activity);
    Activity update(Activity activity);
    boolean deleteById(Integer id);
}
