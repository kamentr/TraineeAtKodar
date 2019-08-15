package net.kodar.university.dataaccess.repository.studentteacher;

import net.kodar.university.entities.StudentTeacher;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Primary
public interface StudentTeacherRepository extends CrudRepository<StudentTeacher, Integer> {

    @Query(value = "select university.student.first_name, university.student.last_name, university.teacher.first_name, university.teacher.last_name\n" +
            "FROM student \n" +
            "  JOIN student_teacher on student.id = student_teacher.student_id\n" +
            "  JOIN teacher on teacher.id = student_teacher.teacher_id\n", nativeQuery = true)
    List<StudentTeacher> getRelations();

}
