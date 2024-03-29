package net.kodar.trainee.dataaccess.dao.student;

import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.data.StudentDataMap;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class StudentDaoGenericImpl extends StudentDaoGeneric {
    @Override
    protected Integer getId(Student student) {
        return student.getID();
    }

    @Override
    protected Student getByIdentifier(Student student) {
        Collection<Student> list = getData().values();

        return list
                .stream()
                .filter(s -> getIdentifier(s).equals(getIdentifier(student)))
                .findFirst()
                .get();
    }

    @Override
    protected UUID getIdentifier(Student student) {
        return student.getIdentifier();
    }

    @Override
    protected Map<Integer, Student> getData() {
        StudentDataMap studentDataMap = new StudentDataMap();
        return studentDataMap.getStudentDataMap();
    }
}
