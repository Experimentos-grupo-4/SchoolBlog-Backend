package pe.edu.upc.schoolblog.mapping;



import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.domain.entity.Mark;
import pe.edu.upc.schoolblog.resource.CreateMarkResource;
import pe.edu.upc.schoolblog.resource.MarkResource;
import pe.edu.upc.schoolblog.resource.UpdateMarkResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
public class MarkMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;




    public Mark toModel (CreateMarkResource resource){
        return this.mapper.map(resource,Mark.class);

    }

    public Mark toModel (UpdateMarkResource resource){

        return this.mapper.map(resource,Mark.class);
    }

    public MarkResource toResource (Mark mark){

        return this.mapper.map(mark,MarkResource.class);
    }
}
