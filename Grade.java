package studentadministration;

public class Grade {
    private Student student;
    private Course course;
    private double score;
    private String letterGrade;
    private double gradePoint;

    public Grade(Student student, Course course, double score) {
        this.student = student;
        this.course = course;
        this.score = score;
        calculateGrade();
    }

    private void calculateGrade() {
        if (score >= 90) {
            letterGrade = "A";
            gradePoint = 4.0;
        } else if (score >= 80) {
            letterGrade = "B";
            gradePoint = 3.0;
        } else if (score >= 70) {
            letterGrade = "C";
            gradePoint = 2.0;
        } else if (score >= 60) {
            letterGrade = "D";
            gradePoint = 1.0;
        } else {
            letterGrade = "F";
            gradePoint = 0.0;
        }
    }

    // Getters and Setters
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public double getScore() { return score; }
    public void setScore(double score) {
        this.score = score;
        calculateGrade();
    }

    public String getLetterGrade() { return letterGrade; }
    public double getGradePoint() { return gradePoint; }

    @Override
    public String toString() {
        return "Grade: " + student.getName() + " - " + course.getCourseName() +
                ": " + score + " (" + letterGrade + ")";
    }
}