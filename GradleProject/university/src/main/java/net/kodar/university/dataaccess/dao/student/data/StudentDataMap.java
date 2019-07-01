package net.kodar.university.dataaccess.dao.student.data;

import net.kodar.university.data.entities.Student;

import java.util.*;

public class StudentDataMap {


    private static List<Student> studentData = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov"),
                    new Student(2, "Ivan", "Ivanov"),
                    new Student(3, "Spas", "Todorov"),
                    new Student(4, "Mihail", "Tryanov"),
                    new Student(5, "MapMihail", "Tryanov"),
                    new Student(6, "MapMihail", "Tryanov")
            )
    );

    private static Map<Integer, Student> studentDataMap = new HashMap<>();

    public Map<Integer, Student> getStudentDataMap() {
        return studentDataMap;
    }

    public StudentDataMap() {
        studentData.forEach(s -> studentDataMap.put(s.getID(), s));
    }
}
