package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.Studentservice;
import com.example.demo.entity.StudentEntity;

@RestController
public class StudentController {
    @Autowired
    Studentservice Studentservice;

    @PostMapping("/add")
    public StudentEntity post(@RequestBody StudentEntity student) {
        return Studentservice.saveData(student);
    }

    @GetMapping("/get")
    public List<StudentEntity> getAllStudents() {
        return Studentservice.getAllStudentEntity();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity> get(@PathVariable int id) {
        return Studentservice.getStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody StudentEntity student, @PathVariable int id) {
        Optional<StudentEntity> existingStudent = Studentservice.getStudent(id);
        if (existingStudent.isPresent()) {
            student.setId(id);
            Studentservice.insertStudent(student);
            return "Student updated successfully";
        } else {
            return "Student not found";
        }

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<StudentEntity> student = Studentservice.getStudent(id);
        if (student.isPresent()) {
            Studentservice.deleteStudent(id);
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}