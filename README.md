# Student Administration System

A console-based Java application for managing student records, course enrollment, and grades.

## Overview

This system allows administrators to register students, create courses, enroll students in courses, and record and track academic grades and GPA.

## Project Structure

```
studentadministration/
├── Person.java                    # Abstract base class for people
├── Student.java                   # Student entity (extends Person)
├── Course.java                    # Course entity
├── Grade.java                     # Grade entity with auto letter-grade calculation
└── StudentAdministrationSystem.java  # Main application with menu-driven UI
```

## Class Design

| Class | Description |
|---|---|
| `Person` | Abstract class with common fields: ID, name, email, phone, address, date of birth |
| `Student` | Extends `Person`; manages enrolled courses, grades, and GPA calculation |
| `Course` | Holds course details and a list of enrolled students |
| `Grade` | Links a student to a course score; auto-calculates letter grade and grade point |
| `StudentAdministrationSystem` | Orchestrates all operations via an interactive menu |

## OOP Concepts Used

- **Encapsulation** — All fields are private with public getters/setters
- **Inheritance** — `Student` extends the abstract `Person` class
- **Polymorphism** — `Student` overrides the abstract `getRole()` method
- **Abstraction** — `Person` defines a contract via the abstract `getRole()` method

## Grading Scale

| Score | Letter Grade | Grade Points |
|---|---|---|
| 90 – 100 | A | 4.0 |
| 80 – 89 | B | 3.0 |
| 70 – 79 | C | 2.0 |
| 60 – 69 | D | 1.0 |
| 0 – 59 | F | 0.0 |

GPA is calculated as a weighted average based on course credits.

## Requirements

- Java 8 or higher

## Running the Application

1. Compile all source files:
   ```bash
   javac studentadministration/*.java
   ```

2. Run the main class:
   ```bash
   java studentadministration.StudentAdministrationSystem
   ```

## Menu Options

```
=== Student Administration System ===
1. Register Student
2. Add Course
3. Enroll Student in Course
4. Add Grade
5. Display All Students
6. Display All Courses
7. Display Student Details
8. Exit
```

## Usage Example

1. **Add a course** (Option 2) — Enter course code, name, credits, instructor, and max capacity
2. **Register a student** (Option 1) — Enter personal details and major
3. **Enroll the student** (Option 3) — Link a student ID to a course code
4. **Add a grade** (Option 4) — Enter a score (0–100) for a student in a course
5. **View student details** (Option 7) — See enrolled courses, grades, and current GPA

## Notes

- Student IDs and course codes must be unique
- A student cannot be enrolled in the same course twice
- Courses enforce a maximum student capacity
- GPA updates automatically whenever a new grade is added
