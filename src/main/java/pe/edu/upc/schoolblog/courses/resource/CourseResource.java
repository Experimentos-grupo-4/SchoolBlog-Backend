package pe.edu.upc.schoolblog.courses.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {
    private Integer id;
    private String name;
    private String description;
}
