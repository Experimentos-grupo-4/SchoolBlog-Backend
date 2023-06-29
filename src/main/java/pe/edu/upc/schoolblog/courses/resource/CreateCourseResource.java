package pe.edu.upc.schoolblog.courses.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseResource {
    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 50, max = 200)
    private String description;
}
