package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.repository.student.StudentRepository;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoGenericImpl extends StudentDaoGeneric {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Integer getId(Student student) {
        return student.getId();
    }

    public List<Student> getStudentById(Integer teacherId) {
        return this.studentRepository.getStudentByTeacherId(teacherId);
    }
}
