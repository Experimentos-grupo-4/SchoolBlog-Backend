package pe.edu.upc.schoolblog.activities.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;

@Getter
@Setter
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    @NotBlank
    @Column(name = "title", length = 2, nullable = false)
    private String title;

    @NotNull
    @Size(min = 2, max = 50)
    @NotBlank
    @Column(name = "description", length = 2, nullable = false)
    private String description;
}
