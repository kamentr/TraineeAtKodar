package net.kodar.university.dataaccess.repository;

import net.kodar.university.data.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
