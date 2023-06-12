package pe.edu.upc.schoolblog.teachers.api;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import pe.edu.upc.schoolblog.teachers.domain.service.TeacherService;

import pe.edu.upc.schoolblog.teachers.mapping.TeacherMapper;

import pe.edu.upc.schoolblog.teachers.resource.CreateTeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.TeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.UpdateTeacherResource;

import java.util.List;

@RestController

@RequestMapping("teachers")

@AllArgsConstructor

public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherMapper mapper;

    @PostMapping

    public TeacherResource save(@RequestBody CreateTeacherResource resource) {

        return mapper.toResource(teacherService.save(mapper.toModel(resource)));

    }

    @GetMapping

    public List<Teacher> fetchAll() {

        return teacherService.fetchAll();

    }

    @GetMapping("{id}")

    public TeacherResource fetchId(@PathVariable Integer id) {

        return this.mapper.toResource(teacherService.fetchById(id).get());

    }

    @PutMapping("{id}")

    public ResponseEntity<TeacherResource> update(@PathVariable Integer id,

                                                  @RequestBody UpdateTeacherResource resource) {

        if (id.equals(resource.getId())) {

            //the same que create

            TeacherResource teacherResource = (mapper.toResource(teacherService.update(mapper.toModel(resource))));//convert resource to model

            return new ResponseEntity<>(teacherResource, HttpStatus.OK);

        } else {

            return ResponseEntity.badRequest().build();

        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (teacherService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
