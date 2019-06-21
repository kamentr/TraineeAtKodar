package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.data.entities.StudentTeacher;

import java.util.List;

public interface StudentTeacherProcessor {

    List<StudentTeacher> filterByStudent(Integer id);

    List<StudentTeacher> filterByTeacher(Integer id);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
