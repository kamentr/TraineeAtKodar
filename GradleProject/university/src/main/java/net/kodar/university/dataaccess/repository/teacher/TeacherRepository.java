package net.kodar.university.dataaccess.repository.teacher;

import net.kodar.university.data.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Query(value ="select t.*\n" +
            "FROM teacher t\n" +
            " JOIN student_teacher st on t.id = st.teacher_id\n" +
            " JOIN student s on s.id = st.student_id\n" +
            " where s.id = ?1\n"
            , nativeQuery = true)
    Collection<Teacher> getTeachersByStudentId(Integer id);
}
