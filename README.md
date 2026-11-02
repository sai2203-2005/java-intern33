# 🎓 Student Management System (Core Java)

[![Java](https://img.shields.io/badge/Java-8%2B%20%2F%2023-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![Paradigm](https://img.shields.io/badge/OOP-Collections%20%26%20Encapsulation-blueviolet.svg)]()

A modular, menu-driven console application developed in **Core Java** to manage student academic records, enrolled subjects, subject-wise marks, dynamic letter grading, and cohort-level academic performance summaries.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [System Architecture](#-system-architecture)
- [Grading Criteria & Passing Policy](#-grading-criteria--passing-policy)
- [Project Structure](#-project-structure)
- [Class Responsibilities](#-class-responsibilities)
- [Core Features](#-core-features)
- [Technologies & Concepts Applied](#-technologies--concepts-applied)
- [How to Compile and Run](#-how-to-compile-and-run)
- [Sample Execution Output](#-sample-execution-output)
- [Future Enhancements Roadmap](#-future-enhancements-roadmap)
- [License](#-license)

---

## 📖 Overview

The **Student Management System** is designed as a foundational software engineering project for educational tracking. It demonstrates the practical application of:
- **Object-Oriented Programming (OOP):** Encapsulation, high cohesion, and low coupling.
- **Java Collections Framework:** `LinkedHashMap` for fast $O(1)$ key-based lookup while preserving insertion order.
- **Defensive Programming:** Robust input validation, subject boundary constraints ($0-100$), and duplicate checking.

---

## 🏗️ System Architecture

```
                       ┌─────────────────────────┐
                       │        Main.java        │
                       │   (Menu Loop & I/O)     │
                       └────────────┬────────────┘
                                    │ delegates
                                    ▼
                       ┌─────────────────────────┐
                       │   StudentService.java   │
                       │ (CRUD & Summary Engine) │
                       └────────────┬────────────┘
                                    │ manages
                                    ▼
                       ┌─────────────────────────┐
                       │      Student.java       │
                       │  (Model, Grades & Pass) │
                       └─────────────────────────┘
```

---

## 📊 Grading Criteria & Passing Policy

### Academic Letter Grading

| Average Marks Range | Letter Grade | Evaluation |
| :---: | :---: | :--- |
| **90.00% – 100.00%** | **A+** | Outstanding |
| **80.00% – 89.99%**  | **A**  | Excellent |
| **70.00% – 79.99%**  | **B**  | Very Good |
| **60.00% – 69.99%**  | **C**  | Good |
| **50.00% – 59.99%**  | **D**  | Satisfactory |
| **35.00% – 49.99%**  | **E**  | Marginal Pass |
| **Below 35.00%**     | **F**  | Needs Improvement (Fail) |

### Passing Criteria:
A student is awarded **`PASS`** status if and only if they score at least **35 marks in every enrolled subject**. If any individual subject mark falls below 35, the overall result is evaluated as **`FAIL`**, regardless of the overall average.

---

## 📁 Project Structure

```
StudentManagementSystem/
│
├── Student.java          # Model: Encapsulates ID, name, department, subjects, grades, and pass/fail logic
├── StudentService.java   # Service: In-memory CRUD operations, ID/Name lookup, and cohort performance analytics
└── Main.java             # Controller: Interactive console menu, input validation, and loop management
```

---

## 🔍 Class Responsibilities

### 1. `Student.java`
* Represents an individual student record.
* Encapsulates `studentId`, `name`, `department`, and `subjectMarks` (`Map<String, Integer>`).
* Computes `calculateAverage()`, `calculatePercentage()`, `calculateGrade()`, and `isPassed()`.

### 2. `StudentService.java`
* Acts as the business logic service managing the `Map<Integer, Student> students` store.
* **CRUD operations:**
  * **Add:** Validates duplicate Student IDs.
  * **Update:** Updates profile information and clears/replaces subject marks.
  * **Search:** Supports lookup by both unique ID ($O(1)$) and case-insensitive Name ($O(N)$).
  * **Delete:** Safely removes student records by ID.
  * **Display All:** Prints individual report sheets for all students.
  * **Performance Summary:** Computes class average, pass percentage, identifies the class topper, and tracks the lowest performer.

### 3. `Main.java`
* Interactive console controller with an 8-option menu.
* Contains `readMarks()` to ensure marks are strictly bounded between $0$ and $100$ and prevents duplicate subject entries during enrollment.
* Prevents Scanner input skipping traps with robust token consumption.

---

## ⚡ Core Features

| Feature | Description |
| :--- | :--- |
| **Add Student** | Registers a new student with ID, Name, Department, and course marks. |
| **Update Student** | Modifies an existing student's details and updates course scores. |
| **Search by ID** | Instant $O(1)$ lookup using student ID. |
| **Search by Name** | Case-insensitive search across student names. |
| **Delete Student** | Removes record from system with validation. |
| **Display All** | Tabulates all student profiles, subjects, averages, and pass/fail results. |
| **Performance Summary** | Computes cohort analytics: class average, topper, pass percentage, and lowest performer. |

---

## 🧠 Technologies & Concepts Applied

| Concept | Application |
| :--- | :--- |
| **OOP & Encapsulation** | Private instance variables accessed through getters and business methods. |
| **Map & LinkedHashMap** | Maps student IDs to student objects while preserving insertion sequence. |
| **Collection Traversal** | Iterating over entry sets and collection values using enhanced for-loops. |
| **Defensive I/O** | Input validation ensuring numerical score bounds ($0 \le \text{mark} \le 100$). |
| **Separation of Concerns** | Isolated data model, business logic service, and UI controller. |

---

## 🚀 How to Compile and Run

### Prerequisites
* **Java Development Kit (JDK) 8 or higher** (JDK 17, 21, or 23 recommended).

### Commands

1. **Compile all files:**
   ```powershell
   javac Student.java StudentService.java Main.java
   ```

2. **Execute the application:**
   ```powershell
   java Main
   ```

---

## 🖥️ Sample Execution Output

```text
===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. Update Student
3. Search Student by ID
4. Search Student by Name
5. Delete Student
6. Display All Students
7. Performance Summary
8. Exit

Enter your choice: 1

Enter Student ID: 101
Enter Student Name: Rahul
Enter Department: CSE
Enter number of subjects: 3
Enter subject name: Java
Enter marks (0-100): 95
Enter subject name: DBMS
Enter marks (0-100): 85
Enter subject name: Python
Enter marks (0-100): 90
Student added successfully!

===== STUDENT MANAGEMENT SYSTEM =====
Enter your choice: 6

========== STUDENT DETAILS ==========
Student ID: 101
Name: Rahul
Department: CSE

Subject Marks:
Java : 95
DBMS : 85
Python : 90

Average: 90.00
Percentage: 90.00%
Grade: A+
Result: PASS
=====================================

===== STUDENT MANAGEMENT SYSTEM =====
Enter your choice: 7

======= ACADEMIC PERFORMANCE SUMMARY =======
Total Students: 1
Class Average: 90.00
Passed Students: 1
Failed Students: 0
Pass Percentage: 100.00%

Topper: Rahul
Highest Average: 90.00
Lowest Performer: Rahul
Lowest Average: 90.00
============================================

===== STUDENT MANAGEMENT SYSTEM =====
Enter your choice: 8
Thank you for using the system!
```

---

## 🗺️ Future Enhancements Roadmap

- [ ] **Database Connectivity (JDBC + MySQL):** Persist student records to a relational database.
- [ ] **Authentication & Security:** Add role-based authentication (Admin vs. Faculty vs. Student).
- [ ] **PDF Report Card Export:** Generate formatted academic transcripts.
- [ ] **GUI Front-End:** Build a modern desktop interface using JavaFX or a web dashboard with Spring Boot + React.

---

## 📜 License

This project is licensed under the MIT License - feel free to use it for learning, coursework, and internship portfolio demonstration.

