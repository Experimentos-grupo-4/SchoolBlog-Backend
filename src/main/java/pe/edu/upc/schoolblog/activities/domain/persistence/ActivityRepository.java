package pe.edu.upc.schoolblog.activities.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.activities.domain.model.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
