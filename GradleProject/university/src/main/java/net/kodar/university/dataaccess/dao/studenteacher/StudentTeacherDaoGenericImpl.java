package net.kodar.university.dataaccess.dao.studenteacher;

import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.repository.studentteacher.StudentTeacherCustomRepository;
import net.kodar.university.dataaccess.repository.studentteacher.StudentTeacherCustomRepositoryImpl;
import net.kodar.university.dataaccess.repository.studentteacher.StudentTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentTeacherDaoGenericImpl extends StudentTeacherDaoGeneric {

    @Autowired
    private StudentTeacherRepository studentTeacherRepository;

    @Override
    protected Integer getId(StudentTeacher studentTeacher) {
        return studentTeacher.getId();
    }

}
