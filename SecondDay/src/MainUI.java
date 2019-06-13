import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class MainUI {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> studentData = StudentData.studentData;
    private StudentProcessorImpl studentProcessorImpl = new StudentProcessorImpl();
    private StudentDaoImpl studentDao = new StudentDaoImpl();

    public MainUI(){
        PrintMenu();
    }

    private void printStudents() {
        studentData.forEach(s -> System.out.println(s));
        PrintMenu();
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
        System.out.println("Succefully added!");

        PrintMenu();
    }


    private void PrintMenu() {
        System.out.println("--------Student Manager--------");
        System.out.println("1. Print list of students");
        System.out.println("2. Add new student");
        System.out.println("3. Get student by ID");
        System.out.println("4. Remove a student by number");
        System.out.println("5. Remove a student");


        String input = scanner.next();
        operator(input);
    }

    private void operator(String input) {
        switch(input){
            case "1":
                printStudents();
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
        }
    }

    private void removeByNumber() {
        scanner.nextLine();
        System.out.println("Write number: ");
        String num = scanner.nextLine();

        studentDao.delete(studentProcessorImpl.getByNumber(num));
        PrintMenu();
    }

    private void getStudentById() {
        System.out.print("Write id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Student> s = studentDao.get(id);
        System.out.println(s);

        PrintMenu();
    }
}
