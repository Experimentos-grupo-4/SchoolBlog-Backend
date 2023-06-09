package pe.edu.upc.schoolblog.teachers.service;

import jakarta.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import pe.edu.upc.schoolblog.teachers.domain.persistence.TeacherRepository;

import pe.edu.upc.schoolblog.teachers.domain.service.TeacherService;

import java.util.List;

import java.util.Optional;

@Service

public class TeacherServiceImpl implements TeacherService {

    @Autowired

    private TeacherRepository teacherRepository;

    @Autowired

    private Validator validator;

    @Transactional(readOnly = true)

    @Override

    public List<Teacher> fetchAll() {

        return teacherRepository.findAll();

    }

    @Transactional(readOnly = true)

    @Override

    public Optional<Teacher> fetchById(Integer id) {

        if (teacherRepository.existsById(id)) {

            return teacherRepository.findById(id);

        } else {

          return Optional.empty();

        }

    }

    @Transactional

    @Override

    public Teacher save(Teacher teacher) {

        return (Teacher) teacherRepository.save(teacher);

    }

    @Transactional

    @Override

    public Teacher update(Teacher teacher) {

        return (Teacher) teacherRepository.save(teacher);

    }

    @Transactional

    @Override

    public boolean deleteById(Integer id) {

        if (teacherRepository.existsById(id)) {

            teacherRepository.deleteById(id);

            return true;

        }

        return false;

    }

}
