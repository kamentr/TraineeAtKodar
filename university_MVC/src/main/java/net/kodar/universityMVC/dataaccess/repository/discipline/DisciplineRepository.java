package net.kodar.universityMVC.dataaccess.repository.discipline;

import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.dataaccess.repository.SoftDeleteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends SoftDeleteRepository<Discipline, Integer> {

    @Query(value = "CALL get_disciplines_by_student_id(?1)", nativeQuery = true)
    List<Discipline> getDisciplinesByStudentId(Integer studentId);
}
