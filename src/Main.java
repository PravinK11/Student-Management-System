
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine().trim();

                    System.out.print("Enter course: ");
                    String course = scanner.nextLine().trim();

                    System.out.print("Enter marks: ");
                    double marks;

                    try {
                        marks = Double.parseDouble(scanner.nextLine().trim());

                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks. Please enter a number.");
                        break;
                    }

                    if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
                        System.out.println("Name, email, and course cannot be empty.");
                        break;
                    }

                    Student student = new Student(name, email, course, marks);
                    boolean success = studentDAO.addStudent(student);

                    if (success) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println(
                                "Failed to add student. Check the error message above."
                        );
                    }
                    break;

                case 2:
                    List<Student> students = studentDAO.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n----- Student Records -----");

                        for (Student s : students) {
                            System.out.println("ID: " + s.getId());
                            System.out.println("Name: " + s.getName());
                            System.out.println("Email: " + s.getEmail());
                            System.out.println("Course: " + s.getCourse());
                            System.out.println("Marks: " + s.getMarks());
                            System.out.println("---------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}

