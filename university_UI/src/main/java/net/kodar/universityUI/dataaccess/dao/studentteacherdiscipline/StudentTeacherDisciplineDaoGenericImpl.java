package net.kodar.universityUI.dataaccess.dao.studentteacherdiscipline;

import net.kodar.universityUI.data.entities.StudentTeacherDiscipline;
import net.kodar.universityUI.dataaccess.dao.DaoImplGeneric;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineDaoGenericImpl extends DaoImplGeneric<Integer, StudentTeacherDiscipline> implements StudentTeacherDisciplineDaoGeneric {

    @Override
    protected Integer getId(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getId();
    }

    @Override
    protected Class<StudentTeacherDiscipline> getClazz() {
        return StudentTeacherDiscipline.class;
    }
}
