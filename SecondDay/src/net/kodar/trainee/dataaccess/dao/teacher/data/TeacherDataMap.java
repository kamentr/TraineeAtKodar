package net.kodar.trainee.dataaccess.dao.teacher.data;

import net.kodar.trainee.data.entities.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TeacherDataMap {

    public Map<Integer, Teacher> getTeacherMap() {
        return teacherMap;
    }

    private static Map<Integer, Teacher> teacherMap = new HashMap<>();

    public TeacherDataMap(){
        ArrayList<Teacher> teacherData = new ArrayList<>(

                Arrays.asList(
                        new Teacher("Ivan", "Ivanov", 1),
                        new Teacher("Ivo", "Ivov", 2),
                        new Teacher("Kiril", "Traikov", 3),
                        new Teacher("Tihomir", "Ivanov", 4)
                )
        );
        for (Teacher t: teacherData) {
            teacherMap.put(t.getId(), t);
        }
    }
}
