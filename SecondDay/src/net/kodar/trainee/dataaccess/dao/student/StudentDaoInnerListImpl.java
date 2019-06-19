package net.kodar.trainee.dataaccess.dao.student;

import net.kodar.trainee.data.entities.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoInnerListImpl implements StudentDao {

    private List<Student> studentData = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov"),
                    new Student(2, "Ivan", "Ivanov"),
                    new Student(3, "Spas", "Todorov"),
                    new Student(4, "Mihail", "Tryanov"),
                    new Student(4, "Inner", "Tryanov")
            )

    );

    @Override
    public Student get(int id) {
        return studentData.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentData;
    }

    @Override
    public void save(Student student) {
        studentData.add(student);
    }

    @Override
    public void update(Student student) {
        Student student1 = get(student.getID());
    }

    @Override
    public void delete(Student student) {
        for(Student s : studentData){
            if(s.getID() == student.getID()){
                studentData.remove(s);
            }
        }
    }

    @Override
    public void delete(int id) {
        studentData.remove(studentData.get(id));
    }
}
