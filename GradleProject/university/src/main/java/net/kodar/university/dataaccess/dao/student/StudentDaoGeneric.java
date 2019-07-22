package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.Dao;

import java.util.List;

public interface StudentDaoGeneric extends Dao<Student> {

    List<Student> getStudentById(Integer teacherId);
}
