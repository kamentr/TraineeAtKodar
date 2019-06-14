import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainUI {

    private Scanner scanner = new Scanner(System.in);
    private StudentProcessor studentProcessorImpl = new StudentProcessorImpl();
    private TeacherDao teacherDao = new TeacherDaoImlp();
    private List<Student> studentData = studentProcessorImpl.getAll();

    public MainUI() {
        PrintMenu();
    }

    private void printStudents(List<Student> studentData) {
        studentData.forEach(s -> System.out.println(s));
        PrintMenu();
    }

    private void PrintMenu() {
        System.out.println("--------Student Manager--------");
        System.out.println("1. Print list of students");
        System.out.println("2. Add new student");
        System.out.println("3. Get student by ID");
        System.out.println("4. Remove a student by number");
        System.out.println("5. Get all students by teacher"); //todo
        System.out.println("6. Get all students by first name"); //todo

        String input = scanner.next();
        operator(input);
    }

    private void saveStudent() {

        System.out.println("Write Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write first name: ");
        String fname = scanner.nextLine();

        System.out.println("Write last name: ");
        String lName = scanner.nextLine();

        System.out.println("Write number: ");
        String number = scanner.nextLine();

        studentData.add(new Student(id, fname, lName, number));
        System.out.println("Successfully added!");

        PrintMenu();
    }


    private void operator(String input) {
        switch (input) {
            case "1":
                printStudents(studentData);
                break;
            case "2":
                saveStudent();
                break;
            case "3":
                getStudentById();
                break;
            case "4":
                removeByNumber();
                break;
            case "5":
                printStudentsByTeacher();
                break;
        }
    }

    private void printStudentsByTeacher() {
        scanner.nextLine();
        System.out.print("Write both teacher names: ");
        String[] name = scanner.nextLine().split("\\s+");
        for(Teacher t : teacherDao.getAll()){
            if(t.getfName().equals(name[0]) && t.getlName().equals(name[1])){
                if(t.getStudents() != null)
                printStudents(t.getStudents());
                else System.out.println("No students");
                break;
            }
        }
        PrintMenu();
    }

    private void removeByNumber() {
        scanner.nextLine();
        System.out.println("Write number: ");
        String num = scanner.nextLine();
        for (Student s : studentData) {
            if (s.getfacNumber().equals(num)) {
                studentData.remove(s);
                break;
            }
        }
        PrintMenu();
    }

    private void getStudentById() {
        System.out.print("Write id: ");
        int id = Integer.parseInt(scanner.next());
        Student s = studentData.get(id);
        System.out.println(s);

        PrintMenu();
    }
}
