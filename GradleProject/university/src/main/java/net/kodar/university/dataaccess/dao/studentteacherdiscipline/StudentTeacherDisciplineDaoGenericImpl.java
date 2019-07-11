package net.kodar.university.dataaccess.dao.studentteacherdiscipline;

import net.kodar.university.data.entities.StudentTeacherDiscipline;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StudentTeacherDisciplineDaoGenericImpl extends StudentTeacherDisciplineDaoGeneric {
    @Override
    protected Integer getId(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getId();
    }
}
