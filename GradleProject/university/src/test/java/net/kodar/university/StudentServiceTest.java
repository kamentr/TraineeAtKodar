package net.kodar.university;


import net.kodar.university.presentation.service.student.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentServiceTest {

    @Mock
    private StudentService mockStudentService;



    @Test
    public void getStudent_byId_returnCorrectStudent(){
            when(mockStudentService.get(any())).thenAnswer(invocation -> invocation.getArgument(0));

    }

}
