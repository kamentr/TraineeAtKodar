package net.kodar.trainee.business.studentteacher;

import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDao;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentTeacherDao studentTeacherDao = new StudentTeacherDaoImpl();


    public StudentTeacherProcessorImpl() {
        studentTeacherList = studentTeacherDao.getAll();
    }

    @Override
    public List<StudentTeacher> filterByStudent(Integer id) {
        return studentTeacherList.stream().filter(student -> student.getStudentId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacher> filterByTeacher(Integer id) {
        return studentTeacherList.stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteStudent(int id) {

        studentTeacherList = studentTeacherList
                .stream()
                .filter(studentTeacher -> studentTeacher.getStudentId() != id)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteTeacher(int id) {
        studentTeacherList =studentTeacherList
                .stream()
                .filter(studentTeacher -> studentTeacher.getTeacherId() != id)
                .collect(Collectors.toList());
    }

    public StudentTeacher get(int id) {
        return studentTeacherDao.get(id);
    }

    public List<StudentTeacher> getAll() {
        return studentTeacherDao.getAll();
    }

    public void save(StudentTeacher studentTeacher) {
        studentTeacherDao.save(studentTeacher);
    }

    public void update(StudentTeacher studentTeacher) {
        studentTeacherDao.update(studentTeacher);
    }

    public void delete(StudentTeacher studentTeacher) {
        studentTeacherDao.delete(studentTeacher);
    }

    public void delete(int id) {
        studentTeacherDao.delete(id);
    }
}
