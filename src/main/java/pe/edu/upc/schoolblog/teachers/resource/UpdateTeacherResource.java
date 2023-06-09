package pe.edu.upc.schoolblog.teachers.resource;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter

@Setter

@With

@AllArgsConstructor

@NoArgsConstructor

public class UpdateTeacherResource {

    @NotNull

    @NotBlank

    @Min(1)

    private Integer id;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String lastName;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String firstName;

}
