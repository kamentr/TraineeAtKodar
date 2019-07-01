package net.kodar.trainee;

import net.kodar.trainee.data.entities.*;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoGeneric;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoGeneric;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoGeneric;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoGenericImpl;

import java.util.List;

class Main {

    public static void main(String[] args) {

        StudentTeacherDiscipline studentTeacherDiscipline = new StudentTeacherDiscipline(12,12,12,11);
        StudentTeacherDisciplineDaoGeneric studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoGenericImpl();
        StudentTeacherDiscipline saveStudentTeacherDiscipline = studentTeacherDisciplineDao.save(studentTeacherDiscipline);

        Student student = new Student(22, "Petko", "Ivanov");
        StudentDaoGeneric studentDaoMap = new StudentDaoGenericImpl();
        Student saveStudent = studentDaoMap.save(student);
        List<Student> all = studentDaoMap.getAll();

        Discipline discipline = new Discipline(11,"Algoritmi");
        DisciplineDaoGeneric disciplineDao = new DisciplineDaoGenericImpl();
        Discipline saveDiscipline = disciplineDao.save(discipline);

        Teacher teacher = new Teacher("Petko","Petkanov", 24);
        TeacherDaoGeneric teacherDaoMap = new TeacherDaoGenericImpl();
        Teacher saveTeacher = teacherDaoMap.save(teacher);

        StudentTeacher studentTeacher = new StudentTeacher(10,2);
        StudentTeacherDaoGeneric studentTeacherDao = new StudentTeacherDaoGenericImpl();
        StudentTeacher saveStudentTeacher = studentTeacherDao.save(studentTeacher);


        System.out.println();

       // MainUI mainUI = new MainUI();
    }
}
