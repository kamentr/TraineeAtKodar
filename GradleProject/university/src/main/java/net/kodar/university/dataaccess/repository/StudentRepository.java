package net.kodar.university.dataaccess.repository;

import net.kodar.university.data.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}