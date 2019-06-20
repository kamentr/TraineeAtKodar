package net.kodar.trainee.presentation;
import net.kodar.trainee.business.discipline.DisciplineProcessor;
import net.kodar.trainee.business.discipline.DisciplineProcessorImpl;
import net.kodar.trainee.business.student.StudentProcessor;
import net.kodar.trainee.business.student.StudentProcessorImpl;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.studentteacherdiscipline.StudentTeacherDisciplineProcessor;
import net.kodar.trainee.business.studentteacherdiscipline.StudentTeacherDisciplineProcessorImpl;
import net.kodar.trainee.business.teacher.TeacherProcessor;
import net.kodar.trainee.business.teacher.TeacherProcessorImpl;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.data.StudentTeacherDisciplineData;


import java.util.Scanner;

public class MainUI {

    private Scanner scanner = new Scanner(System.in);

    private TeacherProcessor teacherProcessor = new TeacherProcessorImpl();
    private StudentProcessor studentProcessor = new StudentProcessorImpl();
    private StudentTeacherProcessor studentTeacherProcessor =  new StudentTeacherProcessorImpl();
    private DisciplineProcessor disciplineProcessor = new DisciplineProcessorImpl();
    private StudentTeacherDisciplineProcessor studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorImpl();

    public MainUI() {
        printMenu();
    }

    private void printMenu() {
        System.out.println("--------Student Manager--------");
        System.out.println("1. Print list of students");
        System.out.println("2. Add new student");
        System.out.println("3. Remove a student by ID");
        System.out.println("4. Print all teachers");
        System.out.println("5. Add new teacher.");
        System.out.println("6. Remove a teacher by ID.");
        System.out.println("7. Add new discipline.");
        System.out.println("8. Remove a discipline by ID.");
        System.out.println("9. Get students by teacher.");       //todo
        System.out.println("10. Get teachers by student.");      //todo
        System.out.println("11. Get discipline by student.");   //todo
        System.out.println("12. Get discipline by teacher.");   //todo

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

    private void getDisciplineByTeacher() {
        System.out.print("Give teacher id: ");
        int id = scanner.nextInt();
        disciplineProcessor.getByTeacherId(id).forEach(System.out::println);

        printMenu();
    }

    private void getDisciplineByStudent() {
        System.out.print("Give student id: ");
        int id = scanner.nextInt();
        disciplineProcessor.getByStudentId(id).forEach(System.out::println);

        printMenu();
    }

    private void getTeachersByStudent() {
        System.out.print("Write student id: ");
        int id = scanner.nextInt();

        teacherProcessor.getTeachersByStudentId(id).forEach(System.out::println);
        printMenu();
    }

    private void getStudentsByTeacher() {
        System.out.print("Write teacher id: ");
        int id = scanner.nextInt();

        studentProcessor.getStudentsByTeacherId(id).forEach(System.out::println);
        printMenu();
    }

    private void printTeachers() {
        teacherProcessor.getAll().forEach(System.out::println);
        printMenu();
    }

    private void printStudents() {
        studentProcessor.getAll().forEach(System.out::println);
        printMenu();
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

        printMenu();
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

        printMenu();
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

        printMenu();
    }

    private void removeStudentById() {
        scanner.nextLine();
        System.out.print("Write id: ");
        int id = scanner.nextInt();
        studentProcessor.delete(id);
        studentTeacherProcessor.deleteStudent(id);

        printMenu();
    }

}
