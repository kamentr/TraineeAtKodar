package net.kodar.trainee.dataАccess.dao.student.data;

import net.kodar.trainee.data.entities.Student;

import java.util.*;

public class StudentDataMap {


    private List<Student> studentData = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov", "1801321018"),
                    new Student(2, "Ivan", "Ivanov", "1801321019"),
                    new Student(3, "Spas", "Todorov", "1801321028"),
                    new Student(4, "Mihail", "Tryanov", "1801321014"),
                    new Student(5, "MapMihail", "Tryanov", "1801321014"),
                    new Student(6, "MapMihail", "Tryanov", "1801321014")
            )
    );

    public static Map<Integer, Student> studentDataMap = new HashMap<>();

    public StudentDataMap(){
        for (Student s: studentData) {
            studentDataMap.put(s.getID(), s);
        }
    }
}
