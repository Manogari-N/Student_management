package com.student;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    private Connection connection;
 
    public StudentDAO() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/studentdb", "postgres", "mano");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO students (id, name, age, email, blood_group, address, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getBloodGroup());
            stmt.setString(6, student.getAddress());
            stmt.setString(7, student.getPhoneNumber());

            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, String email) {
        try {
            String query = "UPDATE students SET name = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String bloodGroup = rs.getString("blood_group");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Blood Group: " + bloodGroup + ", Address: " + address + ", Phone: " + phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addParentDetails(int studentId, String fatherName, String motherName, String fatherPhone, String motherPhone) {
        try {
            String query = "INSERT INTO parents (student_id, father_name, mother_name, father_phone, mother_phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setString(2, fatherName);
            stmt.setString(3, motherName);
            stmt.setString(4, fatherPhone);
            stmt.setString(5, motherPhone);

            stmt.executeUpdate();
            System.out.println("Parent details added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Parent getParentDetails(int studentId) {
        try {
            String query = "SELECT * FROM parents WHERE student_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String fatherName = rs.getString("father_name");
                String motherName = rs.getString("mother_name");
                String fatherPhone = rs.getString("father_phone");
                String motherPhone = rs.getString("mother_phone");

                return new Parent(fatherName, motherName, fatherPhone, motherPhone);
            } else {
                System.out.println("No parent details found for Student ID: " + studentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public void addSiblingDetails(int studentId, String siblingName, String siblingOccupation, String siblingPhone) {
        try {
            String query = "INSERT INTO siblings (student_id, sibling_name, sibling_occupation, sibling_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setString(2, siblingName);
            stmt.setString(3, siblingOccupation);
            stmt.setString(4, siblingPhone);

            stmt.executeUpdate();
            System.out.println("Sibling details added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Sibling> getSiblings(int studentId) {
        List<Sibling> siblings = new ArrayList<>();
        try {
            String query = "SELECT * FROM siblings WHERE student_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String siblingName = rs.getString("sibling_name");
                String siblingOccupation = rs.getString("sibling_occupation");
                String siblingPhone = rs.getString("sibling_phone");

                siblings.add(new Sibling(siblingName, siblingOccupation, siblingPhone));
            }

            if (siblings.isEmpty()) {
                System.out.println("No sibling details found for Student ID: " + studentId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siblings;
    }

    public void addMarkDetails(int studentId, int term1Marks, int term2Marks, int term3Marks, double averageMarks) {
        try {
            String query = "INSERT INTO marks (student_id, term1_marks, term2_marks, term3_marks, average_marks) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setInt(2, term1Marks);
            stmt.setInt(3, term2Marks);
            stmt.setInt(4, term3Marks);
            stmt.setDouble(5, averageMarks);

            stmt.executeUpdate();
            System.out.println("Mark details added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MarkSheet getMarkDetails(int studentId) {
        try {
            String query = "SELECT * FROM marks WHERE student_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int term1Marks = rs.getInt("term1_marks");
                int term2Marks = rs.getInt("term2_marks");
                int term3Marks = rs.getInt("term3_marks");
                double averageMarks = rs.getDouble("average_marks");

                return new MarkSheet(term1Marks, term2Marks, term3Marks, averageMarks);
            } else {
                System.out.println("No mark details found for Student ID: " + studentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
