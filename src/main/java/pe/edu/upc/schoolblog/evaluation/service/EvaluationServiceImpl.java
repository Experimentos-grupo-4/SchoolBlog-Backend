package pe.edu.upc.schoolblog.evaluation.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.domain.persistence.EvaluationRepository;
import pe.edu.upc.schoolblog.evaluation.domain.service.EvaluationService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Evaluation> fetchAll() {
        return evaluationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Evaluation> fetchById(Integer id) {
        if (evaluationRepository.existsById(id)) {
            return evaluationRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Evaluation save(Evaluation evaluation) {

        return evaluationRepository.save(evaluation);
    }

    @Transactional
    @Override
    public Evaluation update(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
