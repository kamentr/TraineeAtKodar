package net.kodar.universityMVC.dataaccess.dao.studenteacher;

import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityMVC.dataaccess.repository.studentteacher.StudentTeacherRepository;
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
