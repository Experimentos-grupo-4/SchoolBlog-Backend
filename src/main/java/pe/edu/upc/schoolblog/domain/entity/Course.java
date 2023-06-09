package pe.edu.upc.schoolblog.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 10, max = 50)
    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @Size(min = 50, max = 200)
    @NotBlank
    @Column(name = "description", length = 200, nullable = false)
    private String description;

}
