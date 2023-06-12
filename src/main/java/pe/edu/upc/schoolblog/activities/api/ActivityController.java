package pe.edu.upc.schoolblog.activities.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.activities.domain.model.entity.Activity;
import pe.edu.upc.schoolblog.activities.domain.persistence.ActivityRepository;
import pe.edu.upc.schoolblog.activities.domain.service.ActivityService;
import pe.edu.upc.schoolblog.activities.mapping.ActivityMapper;
import pe.edu.upc.schoolblog.activities.resources.ActivityResource;
import pe.edu.upc.schoolblog.activities.resources.CreateActivityResource;
import pe.edu.upc.schoolblog.activities.resources.UpdateActivityResource;

import java.util.List;

@RestController
@RequestMapping("activities")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper mapper;

    @PostMapping
    public ActivityResource save(@RequestBody CreateActivityResource resource) {
        return mapper.toResource(activityService.save(mapper.toModel(resource)));
    }

    @GetMapping
    public List<Activity> fetchAll() {
        return activityService.fetchAll();
    }

    @GetMapping("{id}")
    public ActivityResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(activityService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<ActivityResource> update(@PathVariable Integer id,
                                                   @RequestBody UpdateActivityResource resource) {
        if (id.equals(resource.getId())) {
            ActivityResource activityResource = mapper.toResource(activityService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(activityResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (activityService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
