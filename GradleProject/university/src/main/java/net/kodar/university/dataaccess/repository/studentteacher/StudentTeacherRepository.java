package net.kodar.university.dataaccess.repository.studentteacher;

import net.kodar.university.data.entities.StudentTeacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
public interface StudentTeacherRepository extends CrudRepository<StudentTeacher, Integer>, StudentTeacherCustomRepository {

//    @Query("select s.firstName, s.lastName, t.firstName, t.lastName\n" +
//            "FROM s\n" +
//            "  JOIN st on s.id = st.studentId\n" +
//            "  JOIN t on t.Id = st.teacherId")
//    List<StudentTeacher> getRelations();

}
