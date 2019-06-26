package net.kodar.trainee.dataaccess.dao.student;

import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.dataaccess.dao.student.data.StudentDataMap;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class StudentDaoMapImpl implements StudentDao {

    private StudentDataMap studentDataMap = new StudentDataMap();
    private Map<Integer, Student> studentData = StudentDataMap.studentDataMap;

    @Override
    public Student get(int id) {
        return studentData.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentData.values());
    }

    @Override
    public Student save(Student student) {
        if (student != null)
            studentData.put(student.getID(), student);

        Collection<Student> studentList = studentData.values();
        return  studentList
                .stream()
                .filter(s -> s.getIdentifier() == student.getIdentifier())
                .findFirst()
                .get();
    }

    @Override
    public void update(Student student) {
        studentData.put(student.getID(), student);
    }

    @Override
    public void delete(Student student) {
        studentData.remove(student.getID(), student);
    }

    @Override
    public void delete(int id) {
        if(studentData.containsValue(get(id))) {
            Student s = studentData.get(id);
            studentData.remove(s.getID(), s);
        }else {
            //exception
        }
    }
}
