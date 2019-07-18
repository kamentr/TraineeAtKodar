package net.kodar.university.processor;

import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentProcessorTests {

    @Autowired
    StudentProcessorGenericImpl studentProcessor;

    @MockBean
    StudentDaoGenericImpl studentDao;

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


}
