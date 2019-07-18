package net.kodar.university.dataaccess.repository.studentteacher;

import net.kodar.university.data.entities.StudentTeacher;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public class StudentTeacherCustomRepositoryImpl implements StudentTeacherCustomRepository {
//    @Override
//    @Query("select university.student.first_name, university.student.last_name, university.teacher.first_name, university.teacher.last_name\n" +
//            "FROM student \n" +
//            "  JOIN student_teacher on student.id = student_teacher.student_id\n" +
//            "  JOIN teacher on teacher.id = student_teacher.teacher_id")
//    public List<StudentTeacher> getRelations() {
//        return null;
//    }
}
