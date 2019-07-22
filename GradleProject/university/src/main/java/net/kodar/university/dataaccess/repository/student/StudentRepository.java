package net.kodar.university.dataaccess.repository.student;

import net.kodar.university.data.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

    @Query(value ="select s.*\n" +
            "FROM student s\n" +
            "  JOIN student_teacher st on s.id = st.student_id\n" +
            "  JOIN teacher t on t.id = st.teacher_id\n" +
            "  where t.id = ?1"
            , nativeQuery = true)
    List<Student> getStudentByTeacherId(Integer id);
}
