package net.kodar.universityUI.dataaccess.dao.studenteacher;

import net.kodar.universityUI.data.entities.StudentTeacher;
import net.kodar.universityUI.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityUI.dataaccess.repository.studentteacher.StudentTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDaoGenericImpl extends DaoImplGeneric<Integer, StudentTeacher> implements StudentTeacherDaoGeneric {

    @Autowired
    private StudentTeacherRepository studentTeacherRepository;

    @Override
    protected Integer getId(StudentTeacher studentTeacher) {
        return studentTeacher.getId();
    }

    @Override
    protected Class<StudentTeacher> getClazz() {
        return StudentTeacher.class;
    }
}
