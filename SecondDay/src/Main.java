import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentDao processor = new StudentDao();

        List<Student> studentData = processor.getAll();

        studentData.forEach(x -> System.out.println(x));

        System.out.println("-------------------------");

        System.out.println(processor.get(2));

        Student student = new Student(1, "Kamen", "Traikov", "1801321018");

        processor.delete(student);

        processor.save(new Student(4, "Strahil", "Tomov", "1801321029"));

        System.out.println("-------------------------");

        studentData.forEach(x -> System.out.println(x));
    }
}
