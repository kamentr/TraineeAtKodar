package net.kodar.university.processor;

import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentProcessorTests {

    @Autowired
    StudentProcessorGenericImpl studentProcessor;

    @MockBean
    StudentDaoGenericImpl studentDao;

    @MockBean
    private StudentParamGenericParamTransformer studentParamTransformer;

    @MockBean
    private StudentResultGenericResultTransformer studentResultTransformer;

    @MockBean
    private StudentGenericValidatorImpl studentGenericValidator;

    private static Student VALID_STUDENT;

    private static StudentParam VALID_PARAM_STUDENT;

    private static StudentResult VALID_RESULT_STUDENT;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static final String VALID_NAME = "TestName";

    @Before
    public void setUp() throws Exception {
        VALID_STUDENT = new Student();
        VALID_STUDENT.setLastName(VALID_NAME);
        VALID_STUDENT.setFirstName(VALID_NAME);
        VALID_STUDENT.setId(VALID_ID);

        VALID_PARAM_STUDENT = new StudentParam(VALID_ID, VALID_NAME, VALID_NAME);
        VALID_RESULT_STUDENT = new StudentResult(VALID_NAME, VALID_NAME);
        VALID_RESULT_STUDENT.setId(VALID_ID);
    }

    @Test
    public void get_givenValidId_shouldInvokeResultTransformer() {
        when(studentDao.get(VALID_ID)).thenReturn(VALID_STUDENT);
        when(studentResultTransformer.apply(VALID_STUDENT)).thenReturn(VALID_RESULT_STUDENT);

        studentProcessor.get(VALID_ID);

        verify(studentResultTransformer, times(1)).apply(VALID_STUDENT);
        verify(studentDao, times(1)).get(VALID_ID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_givenInvalidId_shouldThrowException() {

        doThrow(IllegalArgumentException.class).when(studentDao).get(INVALID_ID);

        studentProcessor.get(INVALID_ID);
    }

    @Test
    public void getAll_whenInvoked_shouldInvokeDaoGetAll() {
        when(studentDao.getAll()).thenReturn( Arrays.asList(VALID_STUDENT));

        studentProcessor.getAll();

        verify(studentDao, times(1)).getAll();
    }

    @Test
    public void getAll_whenInvoked_shouldInvokeResultTransormer() {
        when(studentDao.getAll()).thenReturn( Arrays.asList(VALID_STUDENT));
        when(studentResultTransformer.apply(VALID_STUDENT)).thenReturn(VALID_RESULT_STUDENT);

        studentProcessor.getAll();

        verify(studentResultTransformer, times(1)).apply(VALID_STUDENT);
    }

    @Test
    public void save_whenInvokedShouldInvokeValidator() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);

        studentProcessor.save(VALID_PARAM_STUDENT);

        verify(studentGenericValidator, times(1)).validate(VALID_PARAM_STUDENT);
    }

    @Test
    public void save_whenInvokedShouldInvokeParamTransformer() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentParamTransformer.apply(VALID_PARAM_STUDENT, null)).thenReturn(VALID_STUDENT);
        studentProcessor.save(VALID_PARAM_STUDENT);

        verify(studentParamTransformer, times(1)).apply(VALID_PARAM_STUDENT, null);
    }

    @Test
    public void save_whenInvokedShouldInvokeResultTransformer() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentParamTransformer.apply(VALID_PARAM_STUDENT, null)).thenReturn(VALID_STUDENT);
        when(studentDao.save(VALID_STUDENT)).thenReturn(VALID_STUDENT);

        studentProcessor.save(VALID_PARAM_STUDENT);

        verify(studentResultTransformer, times(1)).apply(VALID_STUDENT);
    }

    @Test
    public void save_whenInvokedShouldInvokeDaoSave() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentParamTransformer.apply(VALID_PARAM_STUDENT, null)).thenReturn(VALID_STUDENT);

        studentProcessor.save(VALID_PARAM_STUDENT);

        verify(studentDao, times(1)).save(VALID_STUDENT);
    }

    @Test
    public void update_whenInvokedShouldInvokeValidator() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentDao.get(VALID_ID)).thenReturn(VALID_STUDENT);

        studentProcessor.update(VALID_PARAM_STUDENT);

        verify(studentGenericValidator, times(1)).validate(VALID_PARAM_STUDENT);
    }

    @Test
    public void update_whenInvokedShouldInvokeDaoGet() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentDao.get(VALID_ID)).thenReturn(VALID_STUDENT);

        studentProcessor.update(VALID_PARAM_STUDENT);

        verify(studentDao, times(1)).get(VALID_ID);
    }

    @Test
    public void update_whenInvokedShouldInvokeResultTransformer() {
        doNothing().when(studentGenericValidator).validate(VALID_PARAM_STUDENT);
        when(studentDao.get(VALID_ID)).thenReturn(VALID_STUDENT);

        studentProcessor.update(VALID_PARAM_STUDENT);

        verify(studentParamTransformer, times(1)).apply(VALID_PARAM_STUDENT, VALID_STUDENT);
    }

    @Test(expected = NullPointerException.class)
    public void update_whenGivenNull_shouldThrowException() {
        studentProcessor.update(null);
    }


}
