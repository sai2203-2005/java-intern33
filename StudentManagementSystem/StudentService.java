import java.util.*;

public class StudentService {

    // Store student ID and Student object (maintains insertion order)
    private Map<Integer, Student> students = new LinkedHashMap<>();

    // 1. Add Student
    public void addStudent(Student student) {

        int id = student.getStudentId();

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.put(id, student);
        System.out.println("Student added successfully!");
    }

    // 2. Update Student
    public void updateStudent(int id, String name,
                              String department,
                              Map<String, Integer> marks) {

        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.setName(name);
        student.setDepartment(department);

        student.getSubjectMarks().clear();
        student.getSubjectMarks().putAll(marks);

        System.out.println("Student updated successfully!");
    }

    // 3. Search Student by ID
    public void searchStudent(int id) {

        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        displayStudent(student);
    }

    // 4. Search Student by Name
    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students.values()) {

            if (student.getName().equalsIgnoreCase(name)) {
                displayStudent(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 5. Delete Student
    public void deleteStudent(int id) {

        if (students.remove(id) != null) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // 6. Display All Students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        for (Student student : students.values()) {
            displayStudent(student);
        }
    }

    // 7. Display Individual Student Details
    public void displayStudent(Student student) {

        System.out.println("\n========== STUDENT DETAILS ==========");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Department: " + student.getDepartment());

        System.out.println("\nSubject Marks:");

        for (Map.Entry<String, Integer> entry : student.getSubjectMarks().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nAverage: " +
                String.format("%.2f", student.calculateAverage()));

        System.out.println("Percentage: " +
                String.format("%.2f", student.calculatePercentage()) + "%");

        System.out.println("Grade: " + student.calculateGrade());

        System.out.println("Result: " +
                (student.isPassed() ? "PASS" : "FAIL"));

        System.out.println("=====================================");
    }

    // 8. Generate Overall Performance Summary
    public void performanceSummary() {

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        double totalAverage = 0;
        double highestAverage = -1;
        double lowestAverage = 101;

        Student topper = null;
        Student lowestStudent = null;

        int passed = 0;
        int failed = 0;

        for (Student student : students.values()) {

            double average = student.calculateAverage();
            totalAverage += average;

            if (average > highestAverage) {
                highestAverage = average;
                topper = student;
            }

            if (average < lowestAverage) {
                lowestAverage = average;
                lowestStudent = student;
            }

            if (student.isPassed()) {
                passed++;
            } else {
                failed++;
            }
        }

        double classAverage = totalAverage / students.size();

        System.out.println("\n======= ACADEMIC PERFORMANCE SUMMARY =======");
        System.out.println("Total Students: " + students.size());
        System.out.println("Class Average: " + String.format("%.2f", classAverage));
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);
        System.out.println("Pass Percentage: " +
                String.format("%.2f", (passed * 100.0) / students.size()) + "%");

        if (topper != null) {
            System.out.println("\nTopper: " + topper.getName());
            System.out.println("Highest Average: " + String.format("%.2f", highestAverage));
        }

        if (lowestStudent != null) {
            System.out.println("Lowest Performer: " + lowestStudent.getName());
            System.out.println("Lowest Average: " + String.format("%.2f", lowestAverage));
        }

        System.out.println("============================================");
    }
}
