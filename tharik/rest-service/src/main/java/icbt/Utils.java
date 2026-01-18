/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icbt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static final String DB_URL = "jdbc:mysql://localhost:3306/icbt";
    static final String USER = "root";
    static final String PASS = "";

    // ========================
    // Get all students
    // ========================
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

                while (rs.next()) {
                    Student st = new Student();
                    st.setId(rs.getInt("id"));
                    st.setName(rs.getString("name"));
                    st.setDateOfBirth(rs.getString("dob"));
                    students.add(st);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    // ========================
    // Get student by ID
    // ========================
    public static Student getStudent(int id) {
        Student st = null;

        String sql = "SELECT * FROM students WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    st = new Student();
                    st.setId(rs.getInt("id"));
                    st.setName(rs.getString("name"));
                    st.setDateOfBirth(rs.getString("dob"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return st;
    }

    // ========================
    // Add new student
    // ========================
    public static boolean addStudent(Student st) {
        String sql = "INSERT INTO students (name, dob) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, st.getName());
                ps.setString(2, st.getDateOfBirth());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ========================
    // Update student
    // ========================
    public static boolean updateStudent(Student st) {
        String sql = "UPDATE students SET name = ?, dob = ? WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, st.getName());
                ps.setString(2, st.getDateOfBirth());
                ps.setInt(3, st.getId());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ========================
    // Delete student
    // ========================
    public static boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

