package pe.edu.upc.schoolblog.activities.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.activities.domain.model.entity.Activity;
import pe.edu.upc.schoolblog.activities.resources.ActivityResource;
import pe.edu.upc.schoolblog.activities.resources.CreateActivityResource;
import pe.edu.upc.schoolblog.activities.resources.UpdateActivityResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class ActivityMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Activity toModel(CreateActivityResource resource) {
        return this.mapper.map(resource, Activity.class);
    }
    public Activity toModel(UpdateActivityResource resource) {
        return this.mapper.map(resource, Activity.class);
    }

    public ActivityResource toResource(Activity activity) {
        return this.mapper.map(activity, ActivityResource.class);
    }
}
