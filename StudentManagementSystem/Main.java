import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StudentService service = new StudentService();

    // Read subjects and marks with validation
    public static Map<String, Integer> readMarks() {

        Map<String, Integer> marks = new LinkedHashMap<>();

        System.out.print("Enter number of subjects: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= count; i++) {

            System.out.print("Enter subject name: ");
            String subject = sc.nextLine().trim();

            if (marks.containsKey(subject)) {
                System.out.println("Subject already entered. Try again.");
                i--;
                continue;
            }

            int mark;

            while (true) {

                System.out.print("Enter marks (0-100): ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                    continue;
                }

                mark = sc.nextInt();
                sc.nextLine();

                if (mark >= 0 && mark <= 100) {
                    break;
                }

                System.out.println("Marks must be between 0 and 100.");
            }

            marks.put(subject, mark);
        }

        return marks;
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Delete Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Performance Summary");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid menu number.");
                sc.nextLine();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine().trim();

                    Map<String, Integer> marks = readMarks();

                    Student student = new Student(id, name, department);

                    for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                        student.addSubject(entry.getKey(), entry.getValue());
                    }

                    service.addStudent(student);
                    break;

                case 2:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine().trim();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine().trim();

                    Map<String, Integer> newMarks = readMarks();

                    service.updateStudent(
                            updateId,
                            newName,
                            newDepartment,
                            newMarks
                    );
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    service.searchStudent(searchId);
                    break;

                case 4:

                    System.out.print("Enter Student Name: ");
                    String searchName = sc.nextLine().trim();

                    service.searchByName(searchName);
                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    service.deleteStudent(deleteId);
                    break;

                case 6:

                    service.displayAllStudents();
                    break;

                case 7:

                    service.performanceSummary();
                    break;

                case 8:

                    System.out.println("Thank you for using the system!");
                    break;

                default:

                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
