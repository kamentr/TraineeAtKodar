package net.kodar.university.dataaccess.repository;

import net.kodar.university.data.entities.Student;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositiry extends CrudRepository<Student, Integer> {

}
