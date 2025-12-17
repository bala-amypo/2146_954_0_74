package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.Studentservice;

@RestController
public class StudentController {

    @Autowired
    Studentservice studentservice;

    @GetMapping("/get")
    public List<StudentEntity> getAllStudents() {
        return studentservice.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity> get(@PathVariable int id) {
        return studentservice.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody StudentEntity student, @PathVariable int id) {
        Optional<StudentEntity> existingStudent = studentservice.getOneStudent(id);
        if (existingStudent.isPresent()) {
            student.setId(id);
            studentservice.insertStudent(student);
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<StudentEntity> student = studentservice.getOneStudent(id);
        if (student.isPresent()) {
            studentservice.deleteStudent(id);
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
