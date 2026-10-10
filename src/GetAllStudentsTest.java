
import java.util.List;

public class GetAllStudentsTest {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Total students found: " + students.size());
        System.out.println("--------------------------------");

        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("--------------------------------");
        }
    }
}
