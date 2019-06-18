package net.kodar.trainee.business.studentTeacher;

import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataАccess.dao.student.StudentDao;
import net.kodar.trainee.dataАccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.dataАccess.dao.studentTeacher.StudentTeacherDao;
import net.kodar.trainee.dataАccess.dao.studentTeacher.StudentTeacherDaoImpl;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDaoMapImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentDao studentDao = new StudentDaoMapImpl();
    private TeacherDao teacherDao = new TeacherDaoMapImpl();
    StudentTeacherDao studentTeacherDao = new StudentTeacherDaoImpl();


    public StudentTeacherProcessorImpl() {
        studentTeacherList = studentTeacherDao.getAll();
    }

    @Override
    public List<Integer> getByTeacherId(int id) {
        List<Integer> studentList = new ArrayList<>();

        studentTeacherList.stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .forEach(student -> studentList.add(student.getStudentId()));

        return studentList;
    }

    @Override
    public List<Integer> getByStudentId(int id) {
        List<Integer> teacherList = new ArrayList<>();

        studentTeacherList.stream()
                .filter(student -> student.getTeacherId() == id)
                .forEach(student -> teacherList.add(student.getStudentId()));

        return teacherList;
    }


    @Override
    public List<Student> getStudentsByTeacher(Teacher teacher){
        List<Student> students = new ArrayList<>();
        this.getByTeacherId(teacher.getId())
                .forEach(student  -> students.add(studentDao.get(student)));
        return students;
    }

    @Override
    public List<Teacher> getTeachersByStudent(Student student) {
        List<Teacher> teachers = new ArrayList<>();
        this.getByTeacherId(student.getID())
                .forEach(teacher  -> teachers.add(teacherDao.get(teacher)));
        return teachers;
    }

    @Override
    public List<StudentTeacher> filterByStudent(Integer id) {
        return studentTeacherList.stream().filter(student -> student.getStudentId() == id).collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacher> filterByTeacher(Integer id) {
        return studentTeacherList.stream().filter(teacher -> teacher.getTeacherId() == id).collect(Collectors.toList());

    }
}
