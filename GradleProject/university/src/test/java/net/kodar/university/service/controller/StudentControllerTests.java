package net.kodar.university.service.controller;

import net.kodar.university.data.entities.Student;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import net.kodar.university.presentation.service.student.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentService.class)
@ActiveProfiles("test")
public class StudentControllerTests {

    @Autowired
    private MockMvc mvc;

    @Captor
    ArgumentCaptor<StudentParam> studentParamCaptor;

    @MockBean
    private StudentService service;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static Student VALID_STUDENT;

    private static StudentResult VALID_STUDENT_RESULT;

    private static StudentParam VALID_STUDENT_PARAM;

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private static final String REQUEST_BODY = "{" +
            "\"id\": 1,\n" +
            "\"firstName\": \"Test\",\n" +
            "\"lastName\": \"Test\"\n" +
            "}";

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
    public void findAll_shouldReturnAllEntitiesFromBase() throws Exception {
        when(service.getAll()).thenReturn
                (Arrays.asList(VALID_STUDENT_RESULT, VALID_STUDENT_RESULT));

        mvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void get_shouldReturnTheCorrectEntity() throws Exception {
        when(service.get(VALID_ID)).thenReturn(VALID_STUDENT_RESULT);

        mvc.perform(get("/student/" + VALID_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(VALID_STUDENT.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(VALID_STUDENT.getLastName())));
    }

    @Test
    public void delete_whenRequested_shouldInvokeServiceDelete() throws Exception {
        doNothing().when(service).delete(VALID_ID);

        mvc.perform(delete("/student/" + VALID_ID))
                .andExpect(status().isOk());

        verify(service, times(1)).delete(VALID_ID);
    }

    @Test
    public void post_whenRequested_shouldInvokeServiceSave() throws Exception {
        when(service.save(VALID_STUDENT_PARAM)).thenReturn(VALID_STUDENT_RESULT);

        mvc.perform(post("/student")
                .contentType(APPLICATION_JSON_UTF8)
                .content(REQUEST_BODY))
                .andExpect(status().isOk());

        verify(service, times(1)).save(studentParamCaptor.capture());
    }

    @Test
    public void update_givenValidParams_shouldInvokeServiceUpdate() throws Exception {
        doNothing().when(service).update(VALID_ID, VALID_STUDENT_PARAM);

        mvc.perform(put("/student/" + VALID_ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .content(REQUEST_BODY))
                .andExpect(status().isOk());

    }

}
