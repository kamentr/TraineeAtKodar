package net.kodar.university;


import javassist.NotFoundException;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.repository.StudentRepository;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import net.kodar.university.presentation.service.student.StudentService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
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

    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static Student VALID_STUDENT;

    private static StudentParam VALID_STUDENT_PARAM;

    @Before
    public void setUp() throws Exception {
        VALID_STUDENT = new Student();
        VALID_STUDENT.setLastName("Test");
        VALID_STUDENT.setFirstName("Test");
        VALID_STUDENT.setId(VALID_ID);

        VALID_STUDENT_PARAM = new StudentParam(VALID_ID, "Test", "Test");
    }

    @Test
    public void get_givenStudent_returnsTheCorrectStudent(){
        when(studentRepository.findById(VALID_ID)).thenReturn(Optional.of(VALID_STUDENT));

        StudentResult studentResult = studentService.get(VALID_ID);

        assertEquals(studentResult.getFirstName(), VALID_STUDENT.getFirstName());
    }

    @Test(expected = NullPointerException.class)
    public void get_givenInvalidId_ShouldThrowExceprion() {
        studentService.get(INVALID_ID);
    }

    @Test
    public void getAll_givenTwoStudents_shouldReturnTwoStudents() {
        List<Student> studentList = List.of(VALID_STUDENT, VALID_STUDENT);

        when(studentRepository.findAll()).thenReturn(studentList);

        assertEquals(studentService.getAll().size(), 2);
    }

    @Test
    public void delete_tryToDeleteAStudent_shouldThrowException() {
        when(studentRepository.findById(VALID_ID)).thenReturn(Optional.of(VALID_STUDENT));

        studentService.delete(VALID_ID);
        verify(studentRepository, times(1)).deleteById(VALID_ID);
    }

    @Test(expected = Exception.class)
    public void update_givenWrongId_ShouldThrowException() throws Exception {
        studentService.update(VALID_ID, VALID_STUDENT_PARAM);
    }

    @Test(expected = Exception.class)
    public void update_givenStudentToUpdate_ShouldUseTheStudentRepositorySave() throws Exception {

        studentService.update(VALID_ID, VALID_STUDENT_PARAM);

        verify(studentRepository, times(1)).save(any());
    }

    @Test(expected = Exception.class)
    public void save_givenStudentToSave_ShouldUseTheStudentRepositorySave() throws Exception {

        studentService.save(VALID_STUDENT_PARAM);

        verify(studentRepository, times(1)).save(any());
    }


}
