package pe.edu.upc.schoolblog.activities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.activities.domain.model.entity.Activity;
import pe.edu.upc.schoolblog.activities.domain.persistence.ActivityRepository;
import pe.edu.upc.schoolblog.activities.domain.service.ActivityService;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> fetchAll() {
        return activityRepository.findAll();
    }

    @Override
    public Optional<Activity> fetchById(Integer id) {
        if (activityRepository.existsById(id)) {
            return activityRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Transactional
    @Override
    public Activity update(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
