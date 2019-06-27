package net.kodar.trainee;

import net.kodar.trainee.data.entities.*;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoImpl;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoImpl;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoImpl;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoMapImpl;

import java.util.List;

class Main {

    public static void main(String[] args) {

        Student student = new Student(22, "Petko", "Ivanov");
        StudentDaoMapImpl studentDaoMap = new StudentDaoMapImpl();
        Student saveStudent = studentDaoMap.save(student);
        List<Student> all = studentDaoMap.getAll();

        Discipline discipline = new Discipline(11,"Algoritmi");
        DisciplineDaoImpl disciplineDao = new DisciplineDaoImpl();
        Discipline saveDiscipline = disciplineDao.save(discipline);

        Teacher teacher = new Teacher("Petko","Petkanov", 24);
        TeacherDaoMapImpl teacherDaoMap = new TeacherDaoMapImpl();
        Teacher saveTeacher = teacherDaoMap.save(teacher);

        StudentTeacher studentTeacher = new StudentTeacher(10,2);
        StudentTeacherDaoImpl studentTeacherDao = new StudentTeacherDaoImpl();
        StudentTeacher saveStudentTeacher = studentTeacherDao.save(studentTeacher);

        StudentTeacherDiscipline studentTeacherDiscipline = new StudentTeacherDiscipline(12,12,12,2);
        StudentTeacherDisciplineDaoImpl studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoImpl();
        StudentTeacherDiscipline saveStudentTeacherDiscipline = studentTeacherDisciplineDao.save(studentTeacherDiscipline);

        System.out.println();

       // MainUI mainUI = new MainUI();
    }
}
