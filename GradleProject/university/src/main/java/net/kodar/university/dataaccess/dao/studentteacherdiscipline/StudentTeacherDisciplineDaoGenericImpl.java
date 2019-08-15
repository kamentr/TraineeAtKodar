package net.kodar.university.dataaccess.dao.studentteacherdiscipline;

import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.entities.StudentTeacherDiscipline;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineDaoGenericImpl extends DaoImplGeneric<Integer, StudentTeacherDiscipline> implements StudentTeacherDisciplineDaoGeneric{

    @Override
    protected Integer getId(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getId();
    }
}
