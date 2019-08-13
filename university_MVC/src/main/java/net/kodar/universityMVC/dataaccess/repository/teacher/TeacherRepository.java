package net.kodar.universityMVC.dataaccess.repository.teacher;

import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.dataaccess.repository.SoftDeleteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends SoftDeleteRepository<Teacher, Integer> {

    @Query(value = "CALL get_teachers_by_student_id(?1)", nativeQuery = true)
    List<Teacher> getTeachersByStudentId(Integer studentId);
}
