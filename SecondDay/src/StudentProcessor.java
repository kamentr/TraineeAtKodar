import java.util.Optional;

public class StudentProcessor extends StudentDaoImpl {

    public Student getByNumber(String number) {

        for (Student student: studentData) {
            if(student.getNumber() == number)
                return student;
        }

        return null;
    }

    public Student getByFirstName(String fName) {

        for (Student student: studentData) {
            if(student.getFirstName() == fName)
                return student;
        }

        return null;
    }
}
