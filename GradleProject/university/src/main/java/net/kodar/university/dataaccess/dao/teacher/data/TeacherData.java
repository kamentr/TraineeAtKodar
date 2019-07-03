package net.kodar.university.dataaccess.dao.teacher.data;

import net.kodar.university.data.entities.Teacher;

import java.util.ArrayList;
import java.util.Arrays;

public class TeacherData {
    public static ArrayList<Teacher> teacherData= new ArrayList<>(

            Arrays.asList(
                    new Teacher(1, "Ivan", "Ivanov"),
                    new Teacher(2, "Ivo", "Ivov"),
                    new Teacher(3,"Kiril", "Traikov"),
                    new Teacher(4, "Tihomir", "Ivanov"),
                    new Teacher(5, "Dancho", "Ivanov"),
                    new Teacher(6, "Petko", "Ivanov")
            )

    );
}
