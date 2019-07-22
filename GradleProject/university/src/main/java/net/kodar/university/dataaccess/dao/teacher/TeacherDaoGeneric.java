package net.kodar.university.dataaccess.dao.teacher;

import net.kodar.university.data.entities.Teacher;
import net.kodar.university.dataaccess.dao.Dao;

import java.util.List;

public interface TeacherDaoGeneric extends Dao<Teacher> {

    List<Teacher> getTeachersByStudentId(Integer studentId);
}
