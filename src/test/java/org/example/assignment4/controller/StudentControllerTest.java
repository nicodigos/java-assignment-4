package org.example.assignment4.controller;

import org.example.assignment4.model.Student;
import org.example.assignment4.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testGetStudents_ReturnsStudentsList() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(
                new Student("Test Student", "test@example.com", 18)
        ));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("students"))
                .andExpect(view().name("students"));
    }

    @Test
    void testSaveStudent_InvalidData_ReturnsFormWithErrors() throws Exception {
        mockMvc.perform(post("/students/save")
                        .param("name", "")  // Invalid name (empty)
                        .param("email", "invalid-email")  // Invalid email
                        .param("age", "16"))  // Invalid age (< 18)
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("student"))
                .andExpect(view().name("new-student"));
    }
}
