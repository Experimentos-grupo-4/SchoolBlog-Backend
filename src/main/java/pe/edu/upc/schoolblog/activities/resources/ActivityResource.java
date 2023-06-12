package pe.edu.upc.schoolblog.activities.resources;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResource {
    private Integer id;
    private String title;
    private String description;
}
