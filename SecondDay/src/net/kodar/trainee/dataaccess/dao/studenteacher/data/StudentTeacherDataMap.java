package net.kodar.trainee.dataaccess.dao.studenteacher.data;

import net.kodar.trainee.data.entities.StudentTeacher;

import java.util.HashMap;
import java.util.Map;

public class StudentTeacherDataMap {
    public  static Map<Integer, StudentTeacher> studentTeacherData = new HashMap<>();

    public StudentTeacherDataMap(){
        studentTeacherData.put(1, new StudentTeacher(1,1));
        studentTeacherData.put(2, new StudentTeacher(2,3));
        studentTeacherData.put(3, new StudentTeacher(3,3));
        studentTeacherData.put(4, new StudentTeacher(1,4));
        studentTeacherData.put(5, new StudentTeacher(4,2));
        studentTeacherData.put(6, new StudentTeacher(2,2));
    }
}
