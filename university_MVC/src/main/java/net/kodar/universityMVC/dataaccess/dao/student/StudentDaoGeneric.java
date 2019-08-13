package net.kodar.universityMVC.dataaccess.dao.student;


import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.dataaccess.dao.Dao;

import java.util.List;

public interface StudentDaoGeneric extends Dao<Student> {

    List<Student> getStudentsByTeacherId(Integer teacherId);
}
