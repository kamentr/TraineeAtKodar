package net.kodar.universityMVC.dataaccess.repository.studentteacher;

import net.kodar.universityMVC.data.entities.StudentTeacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTeacherRepository extends CrudRepository<StudentTeacher, Integer> {

    @Query(value = "select university.student.first_name, university.student.last_name, university.teacher.first_name, university.teacher.last_name\n" +
            "FROM student \n" +
            "  JOIN student_teacher on student.id = student_teacher.student_id\n" +
            "  JOIN teacher on teacher.id = student_teacher.teacher_id\n", nativeQuery = true)
    List<StudentTeacher> getRelations();

}
