package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students") // ✅ base path
public class StudentController {

    private final StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    // CREATE
    @PostMapping
    public Student postStudent(@RequestBody Student st) {
        return StudentService.insertStudent(st);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return StudentService.getAllStudents();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return StudentService.getOneStudent(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student st) {
        Optional<Student> studentOpt = StudentService.getOneStudent(id);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            student.setCgpa(st.getCgpa());
            student.setDob(st.getDob());

            StudentService.insertStudent(student);
            return "Updated Successfully ✅";
        }
        return "Student Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = StudentService.getOneStudent(id);

        if (student.isPresent()) {
            StudentService.deleteStudent(id);
            return "Deleted Successfully ✅";
        }
        return "Student Not Found ❌";
    }
}