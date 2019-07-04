package net.kodar.university.dataaccess.dao.studenteacher;

import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.data.StudentTeacherDataMap;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component
public class StudentTeacherDaoGenericImpl extends StudentTeacherDaoGeneric {

    @Override
    protected Integer getId(StudentTeacher studentTeacher) {
        return studentTeacher.getId();
    }

    @Override
    protected StudentTeacher getByIdentifier(StudentTeacher studentTeacher) {
        Collection<StudentTeacher> list = this.data.values();
        return list
                .stream()
                .filter(s -> getIdentifier(s).equals(getIdentifier(studentTeacher)))
                .findFirst()
                .get();
    }

    @Override
    protected UUID getIdentifier(StudentTeacher studentTeacher) {
        return studentTeacher.getIdentifier();
    }

    @Override
    protected Map<Integer, StudentTeacher> getData() {
        StudentTeacherDataMap studentTeacherDataMap = new StudentTeacherDataMap();
        return studentTeacherDataMap.getStudentTeacherData();
    }
}
