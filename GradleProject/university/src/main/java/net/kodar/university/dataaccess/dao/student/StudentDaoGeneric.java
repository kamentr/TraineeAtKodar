package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.dataaccess.dao.Dao;
import net.kodar.university.entities.Student;

import java.util.List;

public interface StudentDaoGeneric extends Dao<Student> {

    List<Student> getStudentById(Integer teacherId);
}
