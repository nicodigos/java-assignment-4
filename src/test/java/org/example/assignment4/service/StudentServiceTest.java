package org.example.assignment4.service;

import org.example.assignment4.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testAddStudent_IncreasesListSize() {
        Student student = new Student( "John Doe", "john@example.com", 20);
        studentService.addStudent(student);
        List<Student> students = studentService.getAllStudents();
        assertEquals(1, students.size(), "Student list should contain 1 student");
    }

    @Test
    void testDeleteStudent_RemovesStudent() {
        Student student = new Student( "Jane Doe", "jane@example.com", 22);
        studentService.addStudent(student);
        int id = student.getId();

        studentService.deleteStudent(id);

        assertTrue(studentService.getAllStudents().isEmpty(), "Student list should be empty after deletion");
    }
}
