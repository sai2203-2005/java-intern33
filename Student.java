import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private int studentId;
    private String name;
    private String department;

    // Subject name and corresponding marks
    private Map<String, Integer> subjectMarks;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.subjectMarks = new LinkedHashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addSubject(String subject, int marks) {
        subjectMarks.put(subject, marks);
    }

    public double calculateAverage() {

        if (subjectMarks.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (int marks : subjectMarks.values()) {
            total += marks;
        }

        return (double) total / subjectMarks.size();
    }

    public double calculatePercentage() {
        // Each subject is out of 100
        return calculateAverage();
    }

    public String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else if (average >= 35) {
            return "E";
        } else {
            return "F";
        }
    }

    public boolean isPassed() {

        if (subjectMarks.isEmpty()) {
            return false;
        }

        for (int marks : subjectMarks.values()) {
            if (marks < 35) {
                return false;
            }
        }

        return true;
    }
}

