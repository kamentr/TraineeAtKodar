package net.kodar.universityUI.dataaccess.repository.student;

import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.dataaccess.repository.SoftDeleteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends SoftDeleteRepository<Student, Integer> {

    @Query(value = "CALL `get_students_by_teacher_id(?1)`", nativeQuery = true)
    List<Student> getStudentsByTeacherId(Integer teacherId);
}
