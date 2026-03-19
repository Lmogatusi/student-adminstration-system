package studentadministration;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String studentId;
    private String major;
    private int enrollmentYear;
    private double gpa;
    private List<Course> enrolledCourses;
    private List<Grade> grades;

    public Student(String id, String name, String email, String phone,
                   Date dateOfBirth, String address, String studentId,
                   String major, int enrollmentYear) {
        super(id, name, email, phone, dateOfBirth, address);
        this.studentId = studentId;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.gpa = 0.0;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Polymorphism: Overriding abstract method
    @Override
    public String getRole() {
        return "Student";
    }

    // Student-specific methods
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println("Student " + getName() + " enrolled in " + course.getCourseName());
        }
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
        calculateGPA();
    }

    private void calculateGPA() {
        if (grades.isEmpty()) {
            this.gpa = 0.0;
            return;
        }

        double totalPoints = 0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            totalPoints += grade.getGradePoint() * grade.getCourse().getCredits();
            totalCredits += grade.getCourse().getCredits();
        }

        this.gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public int getEnrollmentYear() { return enrollmentYear; }
    public void setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; }

    public double getGpa() { return gpa; }

    public List<Course> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    public List<Grade> getGrades() { return new ArrayList<>(grades); }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId +
                ", Major: " + major + ", GPA: " + String.format("%.2f", gpa);
    }
}