package net.kodar.university.dataaccess.dao.studenteacher;

import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.dataaccess.repository.studentteacher.StudentTeacherRepository;
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

}
