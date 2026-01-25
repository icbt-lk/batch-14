/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package icbt;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hd
 */
public class UtilsTest {
    
    public UtilsTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of getStudents method, of class Utils.
     */
//    @org.junit.jupiter.api.Test
//    public void testGetStudents() {
//        System.out.println("getStudents");
//        List<Student> expResult = null;
//        List<Student> result = Utils.getStudents();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStudent method, of class Utils.
     */
    @org.junit.jupiter.api.Test
    public void testStudentOperations() {
        System.out.println("testStudentOperations");
        
        Student st = new Student(99, "Yuki", "1999");
        
        System.out.println("Testing add");
        boolean result = Utils.addStudent(st);
        assertEquals(true, result);
        
        Student resultStudent = Utils.getStudent(st.getId());
        assertEquals(st.getId(), resultStudent.getId());
        assertEquals(st.getName(), resultStudent.getName());
        assertEquals(st.getDateOfBirth(), resultStudent.getDateOfBirth());
        
        st.setName("Sergio");
        st.setDateOfBirth("1989");
        System.out.println("Testing add is successful");
        System.out.println("Testing update");
        result = Utils.updateStudent(st);
        assertEquals(true, result);
        
        resultStudent = Utils.getStudent(st.getId());
        assertEquals(st.getId(), resultStudent.getId());
        assertEquals(st.getName(), resultStudent.getName());
        assertEquals(st.getDateOfBirth(), resultStudent.getDateOfBirth());
        System.out.println("Testing updates is successful");
        System.out.println("Testing delete");
        result = Utils.deleteStudent(st.getId());
        assertEquals(true, result);
        
        resultStudent = Utils.getStudent(st.getId());
        assertEquals(null, resultStudent);
        System.out.println("Testing delete is successful");
    }

//    /**
//     * Test of addStudent method, of class Utils.
//     */
//    @org.junit.jupiter.api.Test
//    public void testAddStudent() {
//        System.out.println("addStudent");
//        Student st = null;
//        boolean expResult = false;
//        boolean result = Utils.addStudent(st);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateStudent method, of class Utils.
//     */
//    @org.junit.jupiter.api.Test
//    public void testUpdateStudent() {
//        System.out.println("updateStudent");
//        Student st = null;
//        boolean expResult = false;
//        boolean result = Utils.updateStudent(st);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteStudent method, of class Utils.
//     */
//    @org.junit.jupiter.api.Test
//    public void testDeleteStudent() {
//        System.out.println("deleteStudent");
//        int id = 0;
//        boolean expResult = false;
//        boolean result = Utils.deleteStudent(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
