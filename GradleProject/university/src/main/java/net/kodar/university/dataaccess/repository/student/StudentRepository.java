package net.kodar.university.dataaccess.repository.student;

import net.kodar.university.data.entities.Student;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query(value =
            "select university.student.first_name, university.student.last_name, university.teacher.first_name, university.teacher.last_name\n" +
            "FROM student \n" +
            "  JOIN student_teacher on student.id = student_teacher.student_id\n" +
            "  JOIN teacher on teacher.id = student_teacher.teacher_id", nativeQuery = true)
    List<Student> getStudentByTeacherId(@Param("teacher.id")Integer id);
}
