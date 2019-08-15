package net.kodar.university.dataaccess.dao.student;


import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.dataaccess.repository.student.StudentRepository;
import net.kodar.university.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDaoGenericImpl extends DaoImplGeneric<Integer, Student> implements StudentDaoGeneric  {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Integer getId(Student student) {
        return student.getId();
    }

    @Override
    public List<Student> getStudentById(Integer teacherId) {
        return new ArrayList<>(this.studentRepository.getStudentsByTeacherId(teacherId));
    }
}
