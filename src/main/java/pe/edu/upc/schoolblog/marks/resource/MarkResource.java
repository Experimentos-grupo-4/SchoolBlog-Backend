package pe.edu.upc.schoolblog.marks.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MarkResource {

    private Integer id;
    private String evaluationName;

    private String teacherName;

    private Integer note;

}
