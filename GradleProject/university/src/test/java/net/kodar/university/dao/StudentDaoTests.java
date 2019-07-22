package net.kodar.university.dao;

import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.dataaccess.repository.student.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentDaoTests {

    @Autowired
    private StudentDaoGenericImpl studentDao;

    @MockBean
    private StudentRepository studentRepository;

    private static Student VALID_STUDENT;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static final String VALID_NAME = "TestName";

    @Before
    public void setUp() throws Exception {
        VALID_STUDENT = new Student();
        VALID_STUDENT.setLastName(VALID_NAME);
        VALID_STUDENT.setFirstName(VALID_NAME);
        VALID_STUDENT.setId(VALID_ID);
    }

    @Test
    public void get_givenValidId_ShouldInvokeStudentRepositoryFindById() {
        when(studentRepository.findById(VALID_ID)).thenReturn(Optional.ofNullable(VALID_STUDENT));

        studentDao.get(VALID_ID);

        verify(studentRepository, times(1)).findById(VALID_ID);
    }

    @Test(expected = Exception.class)
    public void get_givenInvalidId_shouldThrowException() {
        when(studentRepository.findById(INVALID_ID)).thenReturn(null);

        studentDao.get(INVALID_ID);
    }

    @Test
    public void getAll_whenInvoked_ShouldInvokeStudentRepositoryFindAll() {
        when(studentRepository.findAll()).thenReturn(Collections.singletonList(VALID_STUDENT));

        studentDao.getAll();

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void save_givenValidStudent_shouldReturnsTheCorrectStudent() {
        when(studentRepository.save(VALID_STUDENT)).thenReturn(VALID_STUDENT);

        Student savedStudent = studentDao.save(VALID_STUDENT);

        assertEquals(studentRepository.save(VALID_STUDENT).getFirstName(), savedStudent.getFirstName());
    }

    @Test
    public void save_givenNull_shouldReturnNull() {
        when(studentRepository.save(null)).thenReturn(null);

        Student nullStudent = studentDao.save(null);

        assertNull(nullStudent);
    }

    @Test
    public void update_whenGivenValidStudent_shouldInvokeRepositorySave() {
        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(VALID_STUDENT));
        when(studentRepository.save(VALID_STUDENT)).thenReturn(VALID_STUDENT);

        studentDao.update(VALID_STUDENT);
        
        verify(studentRepository, times(1)).save(VALID_STUDENT);
    }

    @Test
    public void delete_givenValidStudent_shouldInvokeRepositoryDelete() {
        when(studentRepository.existsById(VALID_ID)).thenReturn(true);
        doNothing().when(studentRepository).delete(VALID_STUDENT);

        studentDao.delete(VALID_STUDENT);

        verify(studentRepository, times(1)).delete(VALID_STUDENT);
        verify(studentRepository, times(1)).existsById(VALID_ID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_whenGivenNull_shouldThrowException() {
        studentDao.delete(null);
    }

    @Test
    public void deleteById_whenGivenValidId_shouldInvokeRepositoryDeleteById() {
        when(studentRepository.existsById(VALID_ID)).thenReturn(true);
        doNothing().when(studentRepository).deleteById(VALID_ID);

        studentDao.deleteById(VALID_ID);

        verify(studentRepository, times(1)).deleteById(VALID_ID);
        verify(studentRepository, times(1)).existsById(VALID_ID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteById_whenGivenINValidId_shouldInvokeRepositoryDeleteById() {
        when(studentRepository.existsById(VALID_ID)).thenReturn(true);
        doNothing().when(studentRepository).deleteById(VALID_ID);

        studentDao.deleteById(INVALID_ID);
    }

    @Test
    public void getId_givenValidStudent_shouldReturnStudentId() {
        Integer expectedId = studentDao.getId(VALID_STUDENT);
        assertEquals(expectedId, VALID_ID);
    }
}
