package net.kodar.university.dataaccess.dao.teacher;

import net.kodar.university.dataaccess.dao.Dao;
import net.kodar.university.entities.Teacher;

import java.util.List;

public interface TeacherDaoGeneric extends Dao<Teacher> {

    List<Teacher> getTeachersByStudentId(Integer studentId);
}
