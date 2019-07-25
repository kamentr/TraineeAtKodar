package net.kodar.university.dataaccess.repository.student;

import net.kodar.university.data.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

    @Query(value ="CALL get_students_by_teacher_id(?1)"
            , nativeQuery = true)
    List<Student> getStudentByTeacherId(Integer id);
}
