package net.kodar.trainee.dataaccess.dao.student.data;

import net.kodar.trainee.data.entities.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentData {

    public static List<Student> studentData = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov"),
                    new Student(2, "Ivan", "Ivanov"),
                    new Student(3, "Spas", "Todorov"),
                    new Student(4, "Mihail", "Tryanov")
            )

    );
}
