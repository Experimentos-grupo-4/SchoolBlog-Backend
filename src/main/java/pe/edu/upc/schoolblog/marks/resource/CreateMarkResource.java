package pe.edu.upc.schoolblog.marks.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateMarkResource {
    @NotNull
    @NotBlank
    private Integer evaluationId;
    @NotNull
    @NotBlank
    private Integer teacherId;
    @NotNull
    @NotBlank
    private Integer studentId;
@NotNull
@NotBlank
@Min(0)
@Max(20)
    private Integer note;

}
