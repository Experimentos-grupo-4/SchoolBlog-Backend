package pe.edu.upc.schoolblog.courses.course;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {
    private Integer id;
    private String name;
    private String knowledge;
    private String description;
}
