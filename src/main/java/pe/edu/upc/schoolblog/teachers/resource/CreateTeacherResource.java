package pe.edu.upc.schoolblog.teachers.resource;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Size;

import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

@Getter

@Setter

@With

@AllArgsConstructor

@NoArgsConstructor

public class CreateTeacherResource {

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String lastName;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String firstName;

}
