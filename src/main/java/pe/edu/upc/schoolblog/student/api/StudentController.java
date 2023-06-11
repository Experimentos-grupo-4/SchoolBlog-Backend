package pe.edu.upc.schoolblog.student.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.student.domain.service.StudentService;
import pe.edu.upc.schoolblog.student.mapping.StudentMapper;
import pe.edu.upc.schoolblog.student.resource.CreateStudentResource;
import pe.edu.upc.schoolblog.student.resource.StudentResource;
import pe.edu.upc.schoolblog.student.resource.UpdateStudentResource;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper mapper;

    @PostMapping
    public StudentResource save(@RequestBody CreateStudentResource resource) {
        return mapper.toResource( studentService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Student> fetchAll() {
        return studentService.fetchAll();
    }

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


}




