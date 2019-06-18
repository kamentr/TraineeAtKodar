package net.kodar.trainee.contracts;

import java.util.List;

public interface StudentTeacherProcessor {

    List<Integer> getByTeacherId(int id);

    List<Integer> getByStudentId(int id);

}
