package net.kodar.trainee.business.student;

import net.kodar.trainee.business.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.StudentDao;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentProcessorImpl implements StudentProcessor {

    private StudentDao studentDao = new StudentDaoMapImpl();
    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();


    @Override
    public Student get(int id) {

        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void save(Student t) {
        studentDao.save(t);
    }

    @Override
    public void update(Student t) {
        studentDao.update(t);
    }

    @Override
    public void delete(Student t) {
        studentDao.delete(t);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> getStudentsByTeacherId(Integer teacherId) {
        List<Student> studentList = new ArrayList<>();

        studentTeacherProcessor
                .filterByTeacher(teacherId)
                .forEach(s -> studentList.add(studentDao.get(s.getStudentId())));

        return studentList;

    }
}