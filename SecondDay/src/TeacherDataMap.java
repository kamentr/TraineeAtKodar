import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TeacherDataMap {
    private ArrayList<Teacher> teacherData= new ArrayList<>(

            Arrays.asList(
                    new Teacher("Ivan", "Ivanov", 1),
                    new Teacher("Ivo", "Ivov", 2),
                    new Teacher("Kiril", "Traikov", 3),
                    new Teacher("Tihomir", "Ivanov", 4)
            )
    );

    static Map<Integer, Teacher> teacherMap = new HashMap<>();

    public TeacherDataMap(){
        for (Teacher t: teacherData) {
            teacherMap.put(t.getId(), t);
        }
    }
}
