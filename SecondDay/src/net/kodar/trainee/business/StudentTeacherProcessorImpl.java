package net.kodar.trainee.business;

import net.kodar.trainee.StudentTeacher;
import net.kodar.trainee.contracts.StudentTeacherProcessor;

import java.util.ArrayList;
import java.util.List;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    List<StudentTeacher> studentTeacherList;

    public StudentTeacherProcessorImpl() {
        studentTeacherList = new ArrayList<>();
    }

    @Override
    public List<Integer> getByTeacherId(int id) {
        List<Integer> studentList = new ArrayList<>();

        studentTeacherList.stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .forEach(student -> studentList.add(student.getStudentId()));

        return studentList;
    }

    @Override
    public List<Integer> getByStudentId(int id) {
        List<Integer> teacherList = new ArrayList<>();

        studentTeacherList.stream()
                .filter(student -> student.getTeacherId() == id)
                .forEach(student -> teacherList.add(student.getStudentId()));

        return teacherList;
    }
}
