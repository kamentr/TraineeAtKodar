package net.kodar.university.dataaccess.repository;

import net.kodar.university.data.entities.StudentTeacher;
import org.springframework.data.repository.CrudRepository;

public interface StudentTeacherRepository extends CrudRepository<StudentTeacher, Integer> {
}
