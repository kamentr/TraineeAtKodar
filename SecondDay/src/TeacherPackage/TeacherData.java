package TeacherPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class TeacherData {
    public static ArrayList<Teacher> teacherData= new ArrayList<Teacher>(

            Arrays.asList(
                        new Teacher("Ivan", "Ivanov", 1),
                        new Teacher("Ivo", "Ivov", 2),
                        new Teacher("Kiril", "Traikov", 3),
                        new Teacher("Tihomir", "Ivanov", 4)
            )

    );
}
