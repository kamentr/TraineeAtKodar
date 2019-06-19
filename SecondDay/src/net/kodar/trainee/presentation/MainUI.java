package net.kodar.trainee.presentation;
import net.kodar.trainee.business.discipline.DisciplineProcessor;
import net.kodar.trainee.business.discipline.DisciplineProcessorImpl;
import net.kodar.trainee.business.student.StudentProcessor;
import net.kodar.trainee.business.student.StudentProcessorImpl;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.teacher.TeacherProcessor;
import net.kodar.trainee.business.teacher.TeacherProcessorImpl;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainUI {

    private Scanner scanner = new Scanner(System.in);

    private TeacherProcessor teacherProcessor = new TeacherProcessorImpl();
    private StudentProcessor studentProcessor = new StudentProcessorImpl();
    private StudentTeacherProcessor studentTeacherProcessor =  new StudentTeacherProcessorImpl();
    private DisciplineProcessor disciplineProcessor = new DisciplineProcessorImpl();

    public MainUI() {
        PrintMenu();
    }


    private void PrintMenu() {
        System.out.println("--------Student Manager--------");
        System.out.println("1. Print list of students");
        System.out.println("2. Add new student");
        System.out.println("3. Remove a student by ID");
        System.out.println("4. Print all teachers");
        System.out.println("5. Add new teacher");
        System.out.println("6. Remove a teacher by ID");
        System.out.println("7. Add new discipline");
        System.out.println("8. Remove a discipline by ID");
        System.out.println("9. Get students by teacher");       //todo
        System.out.println("10. Get teachers by student");      //todo
        System.out.println("11. Get students by discipline");   //todo
        System.out.println("12. Get teachers by discipline");   //todo

        String input = scanner.next();
        operator(input);
    }


    private void operator(String input) {
        switch (input) {
            case "1":
                printStudents();
                break;
            case "2":
                addStudent();
                break;
            case "3":
                removeStudentById();
                break;
            case "4":
                printTeachers();
                break;
            case "5":
                addTeacher();
                break;
            case "6":
                removeTeacherById();
                break;
            case "7":
                addDiscipline();
                break;
            case "8":
                removeDisciplineById();
                break;
        }
    }

    private void printTeachers() {
        teacherProcessor.getAll().forEach(System.out::println);
        PrintMenu();
    }

    private void printStudents() {
        studentProcessor.getAll().forEach(System.out::println);
        PrintMenu();
    }

    private void addStudent() {

        System.out.println("Write Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write first name: ");
        String fname = scanner.nextLine();

        System.out.println("Write last name: ");
        String lName = scanner.nextLine();

        studentProcessor.save(new Student(id, fname, lName));
        System.out.println("Successfully added!");

        PrintMenu();
    }

    private void removeDisciplineById() {
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        disciplineProcessor.delete(id);
    }

    private void addDiscipline() {
        System.out.print("Write discipline name and id: ");
        String[] input = scanner.nextLine().split("\\s+");
        disciplineProcessor.save(new Discipline(Integer.parseInt(input[1]), input[0]));
    }

    private void removeTeacherById() {
        scanner.nextLine();
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        teacherProcessor.delete(id);
        studentTeacherProcessor.deleteTeacher(id);

        PrintMenu();
    }

    private void addTeacher() {
        System.out.println("Write Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write first name: ");
        String fname = scanner.nextLine();

        System.out.println("Write last name: ");
        String lName = scanner.nextLine();

        teacherProcessor.save(new Teacher(fname, lName, id));
        System.out.println("Successfully added!");

        PrintMenu();
    }

    private void removeStudentById() {
        scanner.nextLine();
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        studentProcessor.delete(id);
        studentTeacherProcessor.deleteStudent(id);

        PrintMenu();
    }

}
