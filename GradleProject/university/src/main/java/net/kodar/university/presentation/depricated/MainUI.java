package net.kodar.university.presentation.depricated;
import net.kodar.university.business.processor.discipline.DisciplineProcessorGeneric;
import net.kodar.university.business.processor.discipline.DisciplineProcessorGenericImpl;
import net.kodar.university.business.processor.student.StudentProcessorGeneric;
import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGeneric;
import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
import net.kodar.university.business.processor.teacher.TeacherProcessorGeneric;
import net.kodar.university.business.processor.teacher.TeacherProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;


import javax.validation.ValidationException;
import java.util.Scanner;

public class MainUI {

    private Scanner scanner = new Scanner(System.in);

    private TeacherProcessorGeneric teacherProcessor = new TeacherProcessorGenericImpl();
    private StudentProcessorGeneric studentProcessor = new StudentProcessorGenericImpl();
    private StudentTeacherProcessorGeneric studentTeacherProcessor =  new StudentTeacherProcessorGenericImpl();
    private DisciplineProcessorGeneric disciplineProcessor = new DisciplineProcessorGenericImpl();
    private StudentTeacherDisciplineProcessorGeneric studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorGenericImpl();

    public MainUI() throws ValidationException {
        printMenu();
    }

    private void printMenu() throws ValidationException {
        System.out.println("--------Student Manager--------");
        System.out.println("1. Print list of students");
        System.out.println("2. Add new student");
        System.out.println("3. Remove a student by ID");
        System.out.println("4. Print all teachers");
        System.out.println("5. Add new teacher.");
        System.out.println("6. Remove a teacher by ID.");
        System.out.println("7. Add new discipline.");
        System.out.println("8. Remove a discipline by ID.");
        System.out.println("9. Get students by teacher.");
        System.out.println("10. Get teachers by student.");
        System.out.println("11. Get discipline by student.");
        System.out.println("12. Get discipline by teacher.");

        String input = scanner.next();
        operator(input);
    }


    private void operator(String input) throws ValidationException {
        switch (input) {
            case "1":
                printStudents(); //works
                break;
            case "2":
                addStudent(); //works
                break;
            case "3":
                removeStudentById(); //works
                break;
            case "4":
                printTeachers(); //works
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
            case "9":
                getStudentsByTeacher();
                break;
            case "10":
                getTeachersByStudent();
                break;
            case "11":
                getDisciplineByStudent();
                break;
            case "12":
                getDisciplineByTeacher();
                break;
        }
    }

    private void getDisciplineByTeacher() throws ValidationException {
        System.out.print("Give teacher id: ");
        int id = scanner.nextInt();
        disciplineProcessor.getByTeacherId(id).forEach(System.out::println);

        printMenu();
    }

    private void getDisciplineByStudent() throws ValidationException {
        System.out.print("Give student id: ");
        int id = scanner.nextInt();
        disciplineProcessor.getByStudentId(id).forEach(System.out::println);

        printMenu();
    }

    private void getTeachersByStudent() throws ValidationException {
        System.out.print("Write student id: ");
        int id = scanner.nextInt();

        teacherProcessor.getTeachersByStudentId(id).forEach(System.out::println);
        printMenu();
    }

    private void getStudentsByTeacher() throws ValidationException {
        System.out.print("Write teacher id: ");
        int id = scanner.nextInt();

        studentProcessor.getStudentsByTeacherId(id).forEach(System.out::println);
        printMenu();
    }

    private void printTeachers() throws ValidationException {
        teacherProcessor.getAll().forEach(System.out::println);
        printMenu();
    }

    private void printStudents() throws ValidationException {
        studentProcessor.getAll().forEach(System.out::println);
        printMenu();
    }

    private void addStudent() throws ValidationException {

        System.out.print("Write Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Write first name: ");
        String fname = scanner.nextLine();

        System.out.print("Write last name: ");
        String lName = scanner.nextLine();

        studentProcessor.save(new StudentParam(id, fname, lName));
        System.out.println("Successfully added!");

        printMenu();
    }

    private void removeDisciplineById() throws ValidationException {
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        disciplineProcessor.delete(id);

        printMenu();
    }

    private void addDiscipline() throws ValidationException {
        System.out.print("Write discipline name and id: ");
        scanner.next();
        String[] input = scanner.nextLine().split("\\s+");
        disciplineProcessor.save(new DisciplineParam(Integer.parseInt(input[1]), input[0]));

        printMenu();
    }

    private void removeTeacherById() throws ValidationException {
        scanner.nextLine();
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        teacherProcessor.delete(id);
        studentTeacherProcessor.deleteTeacher(id);

        printMenu();
    }

    private void addTeacher() throws ValidationException {
        System.out.print("Write Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Write first name: ");
        String fname = scanner.nextLine();

        System.out.print("Write last name: ");
        String lName = scanner.nextLine();

        teacherProcessor.save(new TeacherParam(id, fname, lName));
        System.out.println("Successfully added!");

        printMenu();
    }

    private void removeStudentById() throws ValidationException {
        scanner.nextLine();
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        studentProcessor.delete(id);
        studentTeacherProcessor.deleteStudent(id);

        printMenu();
    }

}
