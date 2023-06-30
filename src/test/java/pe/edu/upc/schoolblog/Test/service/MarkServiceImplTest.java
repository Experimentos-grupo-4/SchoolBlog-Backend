package pe.edu.upc.schoolblog.Test.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.marks.domain.persistence.MarkRepository;
import pe.edu.upc.schoolblog.marks.service.MarkServiceImpl;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MarkServiceImplTest {

    @InjectMocks
    private MarkServiceImpl markService;

    @Mock
    private MarkRepository markRepository;

    @Mock
    private Validator validator;




    @Test
    public void testFetchAll() {
        // Arrange
        List<Mark> expected = this.expectedListMark();
        Mockito.when(markRepository.findAll())
                .thenReturn(this.actualListMark());
        // Act
        List<Mark> actual = markService.fetchAll();

        // Assert
        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getStudentId().getId(), actual.get(0).getStudentId().getId());
        Assertions.assertEquals(expected.get(0).getTeacherId().getId(), actual.get(0).getTeacherId().getId());
        Assertions.assertEquals(expected.get(0).getEvaluationId().getId(), actual.get(0).getEvaluationId().getId());
        Assertions.assertEquals(expected.get(0).getNote(), actual.get(0).getNote());

    }

    @Test
    public void testFetchById() {
        // Arrange
        Integer idExpected = 15;
        Integer idActual = 15;
        Optional<Mark> expected = this.expectedOptionalMark(idExpected);

        Mockito.when(markRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.when(markRepository.findById(Mockito.anyInt()))
                .thenReturn(actualOptionalMark(idActual));
        // Act
        Optional<Mark> actual = markService.fetchById(idActual);
        // Assert
        Assertions.assertEquals(expected.get().getId(), actual.get().getId());
        Assertions.assertEquals(expected.get().getStudentId().getId(), actual.get().getStudentId().getId());
        Assertions.assertEquals(expected.get().getTeacherId().getId(), actual.get().getTeacherId().getId());
        Assertions.assertEquals(expected.get().getEvaluationId().getId(), actual.get().getEvaluationId().getId());
        Assertions.assertEquals(expected.get().getNote(), actual.get().getNote());


    }

    @Test
    public void saveTest() {

        Integer idExpected = 15;
        Integer idActual = 14;
        var Mark = createMark(idExpected);

        Mockito.when(markRepository.save(ArgumentMatchers.any())).thenReturn(Mark);

        Mark actualMark= markService.save(Mark);

        Assertions.assertNotEquals(idActual, actualMark.getId());


    }

    @Test
    public void updateTest() {

        Integer expectedEvaluationId = 2;
        Integer expectedTeacherId = 2;
        Integer expectedStudentId= 2;
        Integer expectedNote= 10;


        Mark mark = new Mark();

        mark.setEvaluationId(new Evaluation());
       mark.setStudentId(new Student());
       mark.setTeacherId(new Teacher());
       mark.setNote(15);


        Mockito.when(markRepository.save(ArgumentMatchers.any())).thenReturn(mark);

        Mark actualMark = markService.save(mark);

        Assertions.assertNotEquals(expectedTeacherId, actualMark.getTeacherId());
        Assertions.assertNotEquals(expectedEvaluationId, actualMark.getEvaluationId());
        Assertions.assertNotEquals(expectedStudentId, actualMark.getStudentId());
        Assertions.assertNotEquals(expectedNote, actualMark.getNote());

        Mockito.verify(markRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }


    @Test
    public void deleteTest() {
        Integer idExpected = 15;

        createMark(idExpected);

        Mockito.when(markRepository.existsById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito.doNothing().when(markRepository).deleteById(Mockito.anyInt());

        boolean result = markService.deleteById(15);

        Assertions.assertTrue(result);

    }


    public List<Mark> expectedListMark() {
        List<Mark> expected = new ArrayList<>();

        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student s=new Student();
        s.setId(1);
        s.setLastName("Ayasta");
        s.setFirstName("Valery");
        s.setBirthday(birthday.getTime());
        s.setTiu("123456789");

        Teacher t =new Teacher();
        t.setId(1);
        t.setLastName("Ayasta");
        t.setFirstName("Valery");

        Evaluation e= new Evaluation();
        e.setId(1);

        Mark mark= new Mark();
        mark.setId(1);
       mark.setStudentId(s);
       mark.setTeacherId(t);
       mark.setEvaluationId(e);
       mark.setNote(10);


        expected.add(mark);
        return expected;
    }

    public List<Mark> actualListMark() {
        List<Mark> expected = new ArrayList<>();


        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student s=new Student();
        s.setId(1);
        s.setLastName("Ayasta");
        s.setFirstName("Valery");
        s.setBirthday(birthday.getTime());
        s.setTiu("123456789");

        Teacher t =new Teacher();
        t.setId(1);
        t.setLastName("Ayasta");
        t.setFirstName("Valery");

        Evaluation e= new Evaluation();
        e.setId(1);

        Mark mark= new Mark();
        mark.setId(1);
        mark.setStudentId(s);
        mark.setTeacherId(t);
        mark.setEvaluationId(e);
        mark.setNote(10);


        expected.add(mark);
        return expected;
    }

    public Optional<Mark> expectedOptionalMark(Integer id) {
        return Optional.of(createMark(id));
    }

    public Optional<Mark> actualOptionalMark(Integer id) {
        return Optional.of(createMark(id));
    }


    public Mark createMark(Integer id) {


        Calendar birthday = Calendar.getInstance();
        birthday.set(1990, 2, 15);

        Student s=new Student();
        s.setId(1);
        s.setLastName("Ayasta");
        s.setFirstName("Valery");
        s.setBirthday(birthday.getTime());
        s.setTiu("123456789");

        Teacher t =new Teacher();
        t.setId(1);
        t.setLastName("Ayasta");
        t.setFirstName("Valery");

        Evaluation e= new Evaluation();
        e.setId(1);



        Mark mark= new Mark();
        mark.setId(id);
        mark.setStudentId(s);
        mark.setTeacherId(t);
        mark.setEvaluationId(e);
        mark.setNote(10);


        return mark;
    }

}

