package net.kodar.universityUI.dataaccess.dao.student;


import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.dataaccess.dao.Dao;

import java.util.List;

public interface StudentDaoGeneric extends Dao<Student> {

    List<Student> getStudentsByTeacherId(Integer teacherId);
}
