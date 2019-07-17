package net.kodar.university;


import javassist.NotFoundException;
import net.kodar.university.business.processor.Processor;
import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.repository.StudentRepository;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import net.kodar.university.presentation.service.student.StudentService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.xml.validation.Validator;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentServiceTests {

    @MockBean
    private StudentProcessorGenericImpl studentProcessor;

    @Autowired
    private StudentService studentService;

    @Captor
    ArgumentCaptor<StudentParam> studentParamCaptor;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static Student VALID_STUDENT;

    private static StudentResult VALID_STUDENT_RESULT;

    private static StudentParam VALID_STUDENT_PARAM;

    @Before
    public void setUp() throws Exception {
        VALID_STUDENT = new Student();
        VALID_STUDENT.setLastName("Test");
        VALID_STUDENT.setFirstName("Test");
        VALID_STUDENT.setId(VALID_ID);

        VALID_STUDENT_RESULT = new StudentResult("Test", "Test");
        VALID_STUDENT_RESULT.setId(VALID_ID);

        VALID_STUDENT_PARAM = new StudentParam(VALID_ID, "Test", "Test");
    }

    @Test
    public void get_givenStudent_returnsTheCorrectStudent(){
        when(studentProcessor.get(VALID_ID)).thenReturn(VALID_STUDENT_RESULT);

        StudentResult studentResult = studentService.get(VALID_ID);

        assertEquals(studentResult.getFirstName(), VALID_STUDENT.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_givenInvalidId_ShouldThrowException() {
        when(studentProcessor.get(INVALID_ID)).thenThrow(new IllegalArgumentException());
        studentService.get(INVALID_ID);
    }

    @Test
    public void getAll_givenTwoStudents_shouldReturnTwoStudents() {
        List<StudentResult> studentList = List.of(VALID_STUDENT_RESULT, VALID_STUDENT_RESULT);

        when(studentProcessor.getAll()).thenReturn(studentList);

        assertEquals(studentService.getAll().size(), 2);
    }

    @Test
    public void delete_tryToDeleteAStudent_shouldThrowException() {
        when(studentProcessor.get(VALID_ID)).thenReturn(VALID_STUDENT_RESULT);

        studentService.delete(VALID_ID);
        verify(studentProcessor, times(1)).delete(VALID_ID);
    }

    @Test(expected = Exception.class)
    public void update_givenWrongId_ShouldThrowException() throws Exception {
        doThrow(new Exception()).when(studentProcessor).update(VALID_STUDENT_PARAM);

        studentService.update(INVALID_ID, VALID_STUDENT_PARAM);
    }

    @Test
    public void update_givenStudentToUpdate_ShouldUseTheStudentRepositorySave() throws Exception {

        doNothing().when(studentProcessor).update(VALID_STUDENT_PARAM);

        studentService.update(VALID_ID, VALID_STUDENT_PARAM);

        verify(studentProcessor, times(1)).update(studentParamCaptor.capture());
    }

    @Test(expected = Exception.class)
    public void save_givenStudentToSave_ShouldUseTheStudentRepositorySave() throws Exception {

        doNothing().when(studentProcessor).save(VALID_STUDENT_PARAM);

        studentService.save(VALID_STUDENT_PARAM);

        verify(studentProcessor, times(1)).save(studentParamCaptor.capture());
    }


}
