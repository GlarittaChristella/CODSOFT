package codsoft.tasks;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade);
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter roll number: ");
        int roll = scanner.nextInt();

        System.out.print("Enter grade: ");
        String grade = scanner.next();

        studentList.add(new Student(name, roll, grade));
        System.out.println("✅ Student added.");
    }

    public static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = scanner.nextInt();

        boolean found = false;
        for (Student s : studentList) {
            if (s.rollNumber == roll) {
                studentList.remove(s);
                System.out.println("✅ Student removed.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("❌ Student not found.");
    }

    public static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = scanner.nextInt();

        boolean found = false;
        for (Student s : studentList) {
            if (s.rollNumber == roll) {
                s.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("❌ Student not found.");
    }

    public static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("📋 Student List:");
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: searchStudent(); break;
                case 4: displayAllStudents(); break;
                case 5: System.out.println("Exiting system. Bye! 👋"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
