package pe.edu.upc.schoolblog.marks.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MarkResource {

    private Integer id;
    private Integer evaluationId;
    private Integer teacherId;
    private Integer studentId;

    private Integer note;

}
