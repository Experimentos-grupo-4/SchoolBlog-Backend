package pe.edu.upc.schoolblog.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.domain.entity.Course;
import pe.edu.upc.schoolblog.domain.service.CourseService;
import pe.edu.upc.schoolblog.mapping.CourseMapper;
import pe.edu.upc.schoolblog.resource.course.CourseResource;
import pe.edu.upc.schoolblog.resource.course.CreateCourseResource;
import pe.edu.upc.schoolblog.resource.course.UpdateCourseResource;

import java.util.List;

@RestController
@RequestMapping("courses")
@AllArgsConstructor
public class CoursesController {
    private final CourseService courseService;
    private final CourseMapper mapper;

    @PostMapping
    public CourseResource save(@RequestBody CreateCourseResource resource) {
        return mapper.toResource(courseService.save(mapper.toModel(resource)));
    }

    @GetMapping
    public List<Course> fetchAll() {
        return courseService.fetchAll();
    }

    @GetMapping("{id}")
    public CourseResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(courseService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseResource> update(@PathVariable Integer id,
                                                 @RequestBody UpdateCourseResource resource) {
        if (id.equals(resource.getId())) {
            CourseResource courseResource = (mapper.toResource(courseService.update(mapper.toModel(resource))));
            return new ResponseEntity<>(courseResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
