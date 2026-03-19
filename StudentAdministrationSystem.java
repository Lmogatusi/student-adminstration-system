package studentadministration;

import java.util.*;

public class StudentAdministrationSystem {
    private Map<String, Student> students;
    private Map<String, Course> courses;
    private List<Grade> grades;
    private Scanner scanner;

    public StudentAdministrationSystem() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.grades = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Student Registration
    public void registerStudent() {
        System.out.println("\n=== Student Registration ===");

        System.out.print("Enter Person ID: ");
        String personId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Major: ");
        String major = scanner.nextLine();

        System.out.print("Enter Enrollment Year: ");
        int enrollmentYear = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = new Student(personId, name, email, phone,
                new Date(), address, studentId,
                major, enrollmentYear);
        students.put(studentId, student);
        System.out.println("Student registered successfully!");
    }

    // Add Course
    public void addCourse() {
        System.out.println("\n=== Add New Course ===");

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();

        scanner.nextLine(); // consume newline
        System.out.print("Enter Instructor: ");
        String instructor = scanner.nextLine();

        System.out.print("Enter Maximum Students: ");
        int maxStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Course course = new Course(courseCode, courseName, credits, instructor, maxStudents);
        courses.put(courseCode, course);
        System.out.println("Course added successfully!");
    }

    // Enroll Student in Course
    public void enrollStudent() {
        System.out.println("\n=== Enroll Student in Course ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        student.enrollCourse(course);
    }

    // Add Grade
    public void addGrade() {
        System.out.println("\n=== Add Student Grade ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        System.out.print("Enter Score (0-100): ");
        double score = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Grade grade = new Grade(student, course, score);
        grades.add(grade);
        student.addGrade(grade);

        System.out.println("Grade added successfully!");
    }

    // Display All Students
    public void displayAllStudents() {
        System.out.println("\n=== All Students ===");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    // Display All Courses
    public void displayAllCourses() {
        System.out.println("\n=== All Courses ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    // Display Student Details
    public void displayStudentDetails() {
        System.out.println("\n=== Student Details ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n" + student);
        System.out.println("Enrolled Courses:");
        for (Course course : student.getEnrolledCourses()) {
            System.out.println("  - " + course.getCourseName());
        }

        System.out.println("Grades:");
        for (Grade grade : student.getGrades()) {
            System.out.println("  - " + grade);
        }
    }

    // Main Menu
    public void showMenu() {
        while (true) {
            System.out.println("\n=== Student Administration System ===");
            System.out.println("1. Register Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Add Grade");
            System.out.println("5. Display All Students");
            System.out.println("6. Display All Courses");
            System.out.println("7. Display Student Details");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    addGrade();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    displayAllCourses();
                    break;
                case 7:
                    displayStudentDetails();
                    break;
                case 8:
                    System.out.println("Thank you for using the Student Administration System!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentAdministrationSystem system = new StudentAdministrationSystem();
        system.showMenu();
    }
}