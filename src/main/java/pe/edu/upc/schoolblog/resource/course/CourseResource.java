package pe.edu.upc.schoolblog.resource.course;

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
