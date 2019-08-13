package net.kodar.universityMVC.dataaccess.dao.student;

import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityMVC.dataaccess.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Student> getStudentsByTeacherId(Integer teacherId) {
        return studentRepository.getStudentsByTeacherId(teacherId);
    }
}
