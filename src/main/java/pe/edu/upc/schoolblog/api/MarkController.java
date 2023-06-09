package pe.edu.upc.schoolblog.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.domain.entity.Mark;
import pe.edu.upc.schoolblog.domain.service.MarkService;
import pe.edu.upc.schoolblog.mapping.MarkMapper;
import pe.edu.upc.schoolblog.resource.MarkResource;
import pe.edu.upc.schoolblog.resource.UpdateMarkResource;

import java.util.List;

@RestController
@RequestMapping("marks")
@AllArgsConstructor
public class MarkController {

    private final MarkService markService;
    private final MarkMapper mapper;

    @GetMapping
    public List<Mark> fetchAll(){
        return markService.fetchAll();
    }

    @GetMapping("{id}")
    public MarkResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(markService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<MarkResource> update(@PathVariable Integer id,
                                               @RequestBody UpdateMarkResource resource) {
        if (id.equals(resource.getId())) {
            MarkResource markResource = mapper.toResource(
                    markService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(markResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (markService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
