package net.kodar.trainee;

import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.presentation.MainUI;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(22, "Petko", "Ivanov");
        StudentDaoMapImpl studentDaoMap = new StudentDaoMapImpl();
        Student save = studentDaoMap.save(student);
        List<Student> all = studentDaoMap.getAll();
        System.out.println(save);
    }
}
