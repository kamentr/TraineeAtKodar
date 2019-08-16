package net.kodar.universityUI.dataaccess.dao.student;

import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityUI.dataaccess.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentDaoGenericImpl extends DaoImplGeneric<Integer, Student> implements StudentDaoGeneric {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Integer getId(Student student) {
        return student.getId();
    }


    @Override
    public List<Student> getStudentsByTeacherId(Integer teacherId) {
        return studentRepository.getStudentsByTeacherId(teacherId);
    }

    @Override
    protected Class<Student> getClazz() {
        return Student.class;
    }
}
