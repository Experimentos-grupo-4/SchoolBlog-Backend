package pe.edu.upc.schoolblog.courses.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseResource {
    @NonNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 50, max = 200)
    private String description;
}
