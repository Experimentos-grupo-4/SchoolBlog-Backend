package pe.edu.upc.schoolblog.marks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.marks.domain.persistence.MarkRepository;
import pe.edu.upc.schoolblog.marks.domain.service.MarkService;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;




    @Transactional(readOnly = true)
    @Override
    public List<Mark> fetchAll() {
        return markRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Mark> fetchById(Integer id) {

       if(markRepository.existsById(id))
        return markRepository.findById(id);
       else return Optional.empty();
    }

    @Transactional
    @Override
    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }
    @Transactional
    @Override
    public Mark update(Mark mark) {
        return markRepository.save(mark);
    }

    @Transactional
    @Override
    public Boolean deleteById(Integer id) {

        if (markRepository.existsById(id)){
            markRepository.deleteById(id);
            return true;

        }
        return false;
    }
}
