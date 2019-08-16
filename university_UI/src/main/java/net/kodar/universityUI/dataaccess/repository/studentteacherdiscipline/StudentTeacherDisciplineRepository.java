package net.kodar.universityUI.dataaccess.repository.studentteacherdiscipline;

import net.kodar.universityUI.data.entities.StudentTeacherDiscipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTeacherDisciplineRepository extends CrudRepository<StudentTeacherDiscipline, Integer> {
}
