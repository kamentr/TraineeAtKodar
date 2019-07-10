package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.data.StudentDataMap;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component
public class StudentDaoGenericImpl extends StudentDaoGeneric {

    public StudentDaoGenericImpl(){

    }

    @Override
    protected Integer getId(Student student) {
        return student.getId();
    }

//    @Override
//    protected Student getByIdentifier(Student student) {
//        Collection<Student> list = this.data.values();
//
//        return list
//                .stream()
//                .filter(s -> getIdentifier(s).equals(getIdentifier(student)))
//                .findFirst()
//                .get();
//    }
//
//    @Override
//    protected UUID getIdentifier(Student student) {
//        return student.getIdentifier();
//    }

    @Override
    protected Map<Integer, Student> getData() {
        StudentDataMap dataMap = new StudentDataMap();
        return dataMap.getStudentDataMap();
    }
}
