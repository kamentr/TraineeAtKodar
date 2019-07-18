package net.kodar.university.service;


import net.kodar.university.business.processor.teacher.TeacherProcessorGenericImpl;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;

import net.kodar.university.presentation.service.teacher.TeacherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TeacherServiceTests {

    @MockBean
    private TeacherProcessorGenericImpl teacherProcessor;

    @Autowired
    private TeacherService teacherService;

    @Captor
    ArgumentCaptor<TeacherParam> teacherCaptor;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static Teacher VALID_TEACHER;

    private static TeacherResult VALID_TEACHER_RESULT;

    private static TeacherParam VALID_TEACHER_PARAM;

    @Before
    public void setUp() throws Exception {
        VALID_TEACHER = new Teacher();
        VALID_TEACHER.setLastName("Test");
        VALID_TEACHER.setFirstName("Test");
        VALID_TEACHER.setId(VALID_ID);

        VALID_TEACHER_RESULT = new TeacherResult("Test", "Test");
        VALID_TEACHER_RESULT.setId(VALID_ID);

        VALID_TEACHER_PARAM = new TeacherParam("Test", "Test");
        VALID_TEACHER_PARAM.setId(VALID_ID);
    }

    @Test
    public void get_givenTeacher_returnsTheCorrectTeacher(){
        when(teacherProcessor.get(VALID_ID)).thenReturn(VALID_TEACHER_RESULT);

        TeacherResult teacherResult = teacherService.get(VALID_ID);

        assertEquals(teacherResult.getFirstName(), VALID_TEACHER.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_givenInvalidId_ShouldThrowException() {
        when(teacherProcessor.get(INVALID_ID)).thenThrow(new IllegalArgumentException());
        teacherService.get(INVALID_ID);
    }

    @Test
    public void getAll_givenTwoTeachers_shouldReturnTwoTeachers() {
        List<TeacherResult> teacherList = List.of(VALID_TEACHER_RESULT, VALID_TEACHER_RESULT);

        when(teacherProcessor.getAll()).thenReturn(teacherList);

        assertEquals(teacherService.getAll().size(), 2);
    }

    @Test
    public void delete_tryToDeleteATeacher_shouldThrowException() {
        when(teacherProcessor.get(VALID_ID)).thenReturn(VALID_TEACHER_RESULT);

        teacherService.delete(VALID_ID);
        verify(teacherProcessor, times(1)).delete(VALID_ID);
    }

    @Test(expected = Exception.class)
    public void update_givenWrongId_ShouldThrowException() throws Exception {
        doThrow(new Exception()).when(teacherProcessor).update(VALID_TEACHER_PARAM);

        teacherService.update(INVALID_ID, VALID_TEACHER_PARAM);
    }

    @Test
    public void update_givenTeacherToUpdate_ShouldUseTheTeacherRepositorySave() throws Exception {

        doNothing().when(teacherProcessor).update(VALID_TEACHER_PARAM);

        teacherService.update(VALID_ID, VALID_TEACHER_PARAM);

        verify(teacherProcessor, times(1)).update(teacherCaptor.capture());
    }

    @Test(expected = Exception.class)
    public void save_givenTeacherToSave_ShouldUseTheTeacherRepositorySave() throws Exception {

        doNothing().when(teacherProcessor).save(VALID_TEACHER_PARAM);

        teacherService.save(VALID_TEACHER_PARAM);

        verify(teacherProcessor, times(1)).save(teacherCaptor.capture());
    }


}
