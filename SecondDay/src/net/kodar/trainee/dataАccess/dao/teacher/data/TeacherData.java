package net.kodar.trainee.dataАccess.dao.teacher.data;

import net.kodar.trainee.data.entities.Teacher;

import java.util.ArrayList;
import java.util.Arrays;

public class TeacherData {
    public static ArrayList<Teacher> teacherData= new ArrayList<>(

            Arrays.asList(
                    new Teacher("Ivan", "Ivanov", 1),
                    new Teacher("Ivo", "Ivov", 2),
                    new Teacher("Kiril", "Traikov", 3),
                    new Teacher("Tihomir", "Ivanov", 4)
            )

    );
}
