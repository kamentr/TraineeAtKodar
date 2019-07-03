package net.kodar.university.dataaccess.dao.teacher.data;

import net.kodar.university.data.entities.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TeacherDataMap {

    public Map<Integer, Teacher> getTeacherMap() {
        return teacherMap;
    }

    private Map<Integer, Teacher> teacherMap = new HashMap<>();

    public ArrayList<Teacher> teacherData = new ArrayList<>(

            Arrays.asList(
                    new Teacher(1, "Ivan", "Ivanov"),
                    new Teacher(2, "Ivo", "Ivov"),
                    new Teacher(3, "Kiril", "Traikov"),
                    new Teacher(4, "Tihomir", "Ivanov"),
                    new Teacher(5, "Dancho", "Ivanov"),
                    new Teacher(6, "Petko", "Ivanov")
            )
    );

    public TeacherDataMap() {

        for (Teacher t : teacherData) {
            teacherMap.put(t.getId(), t);
        }
    }
}
