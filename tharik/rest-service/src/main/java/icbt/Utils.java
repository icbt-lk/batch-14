/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icbt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hd
 */
public class Utils {

    static final String DB_URL = "jdbc:mysql://localhost:3306/icbt";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT * FROM students";

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        // Open a connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setDateOfBirth(rs.getString("dob"));
                students.add(st);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.getLogger(Utils.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return students;

    }
}
