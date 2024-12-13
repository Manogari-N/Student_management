package com.student;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Parent Details");
            System.out.println("6. Sibling Details");
            System.out.println("7. Mark Details");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(scanner, studentDAO);
                    break;

                case 2:
                    
                    studentDAO.viewAllStudents();
                    break;

                case 3:
                    
                    updateStudent(scanner, studentDAO);
                    break;

                case 4:
                   
                    deleteStudent(scanner, studentDAO);
                    break;

                case 5:
                    
                    System.out.println("1. Enter Parent Details");
                    System.out.println("2. View Parent Details");
                    System.out.print("Choose an option: ");
                    int parentChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (parentChoice == 1) {
                        enterParentDetails(scanner, studentDAO);
                    } else if (parentChoice == 2) {
                        System.out.print("Enter Student ID to view parent details: ");
                        int studentIdForParent = scanner.nextInt();
                        scanner.nextLine(); 
                        viewParentDetails(studentIdForParent, studentDAO);
                    } else {
                        System.out.println("Invalid choice for Parent Details.");
                    }
                    break;

                case 6:
                    
                    System.out.println("1. Enter Sibling Details");
                    System.out.println("2. View Sibling Details");
                    System.out.print("Choose an option: ");
                    int siblingChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    if (siblingChoice == 1) {
                        enterSiblingDetails(scanner, studentDAO);
                    } else if (siblingChoice == 2) {
                        System.out.print("Enter Student ID to view sibling details: ");
                        int studentIdForSibling = scanner.nextInt();
                        scanner.nextLine(); 
                        viewSiblingDetails(studentIdForSibling, studentDAO);
                    } else {
                        System.out.println("Invalid choice for Sibling Details.");
                    }
                    break;

                case 7:
                    System.out.println("1. Enter Mark Details");
                    System.out.println("2. View Mark Details");
                    System.out.print("Choose an option: ");
                    int marksChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    if (marksChoice == 1) {
                        enterMarkDetails(scanner, studentDAO);
                    } else if (marksChoice == 2) {
                        System.out.print("Enter Student ID to view mark details: ");
                        int studentIdForMarks = scanner.nextInt();
                        scanner.nextLine(); 
                        viewMarkDetails(studentIdForMarks, studentDAO);
                    } else {
                        System.out.println("Invalid choice for Mark Details.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStudent(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Student student = new Student(id, name, age, email, bloodGroup, address, phoneNumber);
        studentDAO.addStudent(student);
    }

    public static void updateStudent(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        studentDAO.updateStudent(id, name, email);
    }

    public static void deleteStudent(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        studentDAO.deleteStudent(id);
    }

    public static void enterParentDetails(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Father's Name: ");
        String fatherName = scanner.nextLine();

        System.out.print("Enter Mother's Name: ");
        String motherName = scanner.nextLine();

        System.out.print("Enter Father's Phone Number: ");
        String fatherPhone = scanner.nextLine();

        System.out.print("Enter Mother's Phone Number: ");
        String motherPhone = scanner.nextLine();

        studentDAO.addParentDetails(studentId, fatherName, motherName, fatherPhone, motherPhone);
    }

    public static void viewParentDetails(int studentId, StudentDAO studentDAO) {
        Parent parent = studentDAO.getParentDetails(studentId);
        if (parent != null) {
            System.out.println("Father's Name: " + parent.getFatherName());
            System.out.println("Mother's Name: " + parent.getMotherName());
            System.out.println("Father's Phone: " + parent.getFatherPhoneNumber());
            System.out.println("Mother's Phone: " + parent.getMotherPhoneNumber());
        } else {
            System.out.println("No parent details found for Student ID: " + studentId);
        }
    }

    public static void enterSiblingDetails(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Sibling Name: ");
        String siblingName = scanner.nextLine();

        System.out.print("Enter Sibling Occupation: ");
        String siblingOccupation = scanner.nextLine();

        System.out.print("Enter Sibling Phone Number: ");
        String siblingPhone = scanner.nextLine();

        studentDAO.addSiblingDetails(studentId, siblingName, siblingOccupation, siblingPhone);
    }

    public static void viewSiblingDetails(int studentId, StudentDAO studentDAO) {
        List<Sibling> siblings = studentDAO.getSiblings(studentId);
        if (siblings != null && !siblings.isEmpty()) {
            for (Sibling sibling : siblings) {
                System.out.println("Sibling Name: " + sibling.getSiblingName());
                System.out.println("Sibling Occupation: " + sibling.getSiblingOccupation());
                System.out.println("Sibling Phone: " + sibling.getSiblingPhoneNumber());
            }
        } else {
            System.out.println("No sibling details found for Student ID: " + studentId);
        }
    }

    public static void enterMarkDetails(Scanner scanner, StudentDAO studentDAO) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Term 1 Marks: ");
        int term1Marks = scanner.nextInt();

        System.out.print("Enter Term 2 Marks: ");
        int term2Marks = scanner.nextInt();

        System.out.print("Enter Term 3 Marks: ");
        int term3Marks = scanner.nextInt();

        double averageMarks = (term1Marks + term2Marks + term3Marks) / 3.0;

        studentDAO.addMarkDetails(studentId, term1Marks, term2Marks, term3Marks, averageMarks);
    }

    public static void viewMarkDetails(int studentId, StudentDAO studentDAO) {
        MarkSheet marksheet = studentDAO.getMarkDetails(studentId);
        if (marksheet != null) {
            System.out.println("Term 1 Marks: " + marksheet.getTerm1Marks());
            System.out.println("Term 2 Marks: " + marksheet.getTerm2Marks());
            System.out.println("Term 3 Marks: " + marksheet.getTerm3Marks());
            System.out.println("Average Marks: " + marksheet.getAverageMarks());
        } else {
            System.out.println("No mark details found for Student ID: " + studentId);
        }
    }
}
