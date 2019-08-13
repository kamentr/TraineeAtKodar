package net.kodar.universityMVC.dataaccess.repository.studentteacherdiscipline;

import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTeacherDisciplineRepository extends CrudRepository<StudentTeacherDiscipline, Integer> {
}
