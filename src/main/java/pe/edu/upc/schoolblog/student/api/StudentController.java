package pe.edu.upc.schoolblog.student.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.domain.service.CourseService;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.student.domain.service.StudentService;
import pe.edu.upc.schoolblog.student.mapping.StudentMapper;
import pe.edu.upc.schoolblog.student.resource.CreateStudentResource;
import pe.edu.upc.schoolblog.student.resource.StudentResource;
import pe.edu.upc.schoolblog.student.resource.UpdateStudentResource;

import java.util.List;

@Tag(name = "Students", description = "Create, Read, Update and Delete students entities")
@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;
    private final StudentMapper mapper;


    @Operation(summary = "Save the student", responses = {
            @ApiResponse(description = "Student successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResource.class)))
    })
    @PostMapping
    public StudentResource save(@RequestBody CreateStudentResource resource) {
        return mapper.toResource( studentService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Student> fetchAll() {
        return studentService.fetchAll();
    }


    @Operation(summary = "Find by id of the student", responses = {
            @ApiResponse(description = "Student successfully found",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResource.class)))
    })
    @GetMapping("{id}")
    public StudentResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(studentService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentResource> update(@PathVariable Integer id,
                                  @RequestBody UpdateStudentResource resource) {
        if (id.equals(resource.getId())) {
            StudentResource studentResource = mapper.toResource(
                    studentService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(studentResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (studentService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{student_id}/courses/{course_id}")
    public ResponseEntity<String> addStudentToCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        Student student = studentService.fetchById(student_id).orElse(null);
        Course course = courseService.fetchById(course_id).orElse(null);

        if (student == null || course == null ){
            return ResponseEntity.notFound().build();
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentService.save(student);

        return ResponseEntity.ok("Student added to course successfully");
    }

}




