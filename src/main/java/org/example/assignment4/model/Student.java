package org.example.assignment4.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {
    private static int idCounter = 1; // Auto-incremental ID

    private Integer id;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    public Student(String name, String email, Integer age) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
