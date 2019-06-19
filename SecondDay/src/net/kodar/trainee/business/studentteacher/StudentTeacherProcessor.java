package net.kodar.trainee.business.studentteacher;

import net.kodar.trainee.data.entities.StudentTeacher;

import java.util.List;

public interface StudentTeacherProcessor {

    List<StudentTeacher> filterByStudent(Integer id);

    List<StudentTeacher> filterByTeacher(Integer id);
}
