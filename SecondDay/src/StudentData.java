import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentData {

    public static List<Student> studentData = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov", "1801321018"),
                    new Student(2, "Ivan", "Ivanov", "1801321019"),
                    new Student(3, "Spas", "Todorov", "1801321028"),
                    new Student(4, "Mihail", "Tryanov", "1801321014")
            )

    );
}
