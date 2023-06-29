package pe.edu.upc.schoolblog.teachers.domain.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Size;

import lombok.Getter;

import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;

import java.util.List;

@Entity

@Table(name = "teachers")

@Getter

@Setter

public class Teacher {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    @Column(name = "last_name", length = 30, nullable = false)

    private String lastName;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    @Column(name = "first_name", length = 30)

    private String firstName;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
