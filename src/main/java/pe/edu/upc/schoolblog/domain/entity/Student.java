package pe.edu.upc.schoolblog.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

    @Entity
    @Table(name = "students")
    @Getter
    @Setter
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotNull
        @NotBlank
        @Size(min = 2, max = 30, message = "El Apellido debe estar entre 2 y 30 caracteres")
        @Column(name = "last_name", length = 30, nullable = false)
        private String lastName;
        @NotNull
        @NotBlank
        @Size(min = 2, max = 30)
        @Column(name = "first_name", length = 30)
        private String firstName;

        @NotNull
        @Past
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "birthday")
        @Temporal(TemporalType.DATE)
        private Date birthday;

        @NotNull
        @NotBlank
        @Size(min = 9, max = 9)
        @Column(name = "tiu", columnDefinition = "char(9)", nullable = false)
        private String tiu;

        @JsonIgnore
        @OneToMany(mappedBy = "studentId") // mapperBy es el object que permite la relación
        private ArrayList<Mark> marks;



}
