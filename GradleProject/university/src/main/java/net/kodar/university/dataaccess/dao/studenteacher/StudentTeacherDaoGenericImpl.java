package net.kodar.university.dataaccess.dao.studenteacher;

import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.data.StudentTeacherDataMap;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class StudentTeacherDaoGenericImpl extends StudentTeacherDaoGeneric {

    @Override
    protected Integer getId(StudentTeacher studentTeacher) {
        return studentTeacher.getId();
    }

    @Override
    protected StudentTeacher getByIdentifier(StudentTeacher studentTeacher) {
        Collection<StudentTeacher> list = getData().values();
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
