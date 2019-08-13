package net.kodar.universityMVC.dataaccess.dao.studentteacherdiscipline;

import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import net.kodar.universityMVC.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityMVC.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineDaoGenericImpl extends DaoImplGeneric<Integer, StudentTeacherDiscipline> implements StudentTeacherDisciplineDaoGeneric {

    @Override
    protected Integer getId(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getId();
    }
}
