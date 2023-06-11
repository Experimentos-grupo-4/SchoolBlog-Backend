package pe.edu.upc.schoolblog.evaluation.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.domain.service.EvaluationService;
import pe.edu.upc.schoolblog.evaluation.mapping.EvaluationMapper;
import pe.edu.upc.schoolblog.evaluation.resource.CreateEvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.EvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.UpdateEvaluationResource;

import java.util.List;

@RestController
@RequestMapping("evaluations")
@AllArgsConstructor
public class EvaluationController {
    private final EvaluationService evaluationService;
    private final EvaluationMapper mapper;

    @PostMapping
    public EvaluationResource save(@RequestBody CreateEvaluationResource resource) {
        return mapper.toResource( evaluationService.save( mapper.toModel(resource)) ) ;
    }

    @GetMapping
    public List<Evaluation> fetchAll() {
        return evaluationService.fetchAll();
    }

    @GetMapping("{id}")
    public EvaluationResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(evaluationService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<EvaluationResource> update(@PathVariable Integer id,
                                                     @RequestBody UpdateEvaluationResource resource) {
        if (id.equals(resource.getId())) {
            EvaluationResource EvaluationResource = mapper.toResource(
                    evaluationService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(EvaluationResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (evaluationService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}




