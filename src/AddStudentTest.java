
public class AddStudentTest {

    public static void main(String[] args) {
        Student student = new Student(
                "Pravin Test",
                "pravin.test@example.com",
                "Java",
                85.50
        );

        StudentDAO studentDAO = new StudentDAO();

        boolean success = studentDAO.addStudent(student);

        if (success) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }
}
