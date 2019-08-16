package net.kodar.universityUI.dataaccess.dao.teacher;

import net.kodar.universityUI.data.entities.Teacher;
import net.kodar.universityUI.dataaccess.dao.Dao;

import java.util.List;

public interface TeacherDaoGeneric extends Dao<Teacher> {
    List<Teacher> getTeachersByStudentId(Integer studentId);
}
