package net.kodar.universityMVC.dataaccess.dao.teacher;

import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.dataaccess.dao.Dao;

import java.util.List;

public interface TeacherDaoGeneric extends Dao<Teacher> {
    List<Teacher> getTeachersByStudentId(Integer studentId);
}
