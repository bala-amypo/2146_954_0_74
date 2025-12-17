package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

private final StudentService studentService;

public StudentController(StudentService studentService) {
this.studentService = studentService;
}

@PostMapping
public StudentEntity postStudent(@RequestBody StudentEntity st) {
return studentService.insertStudent(st);
}

@GetMapping
public List<StudentEntity> getAll() {
return studentService.getAllStudents();
}

@GetMapping("/{id}")
public Optional<StudentEntity> getById(@PathVariable Long id) {
return studentService.getOneStudent(id);
}

@PutMapping("/{id}")
public String updateStudent(@PathVariable Long id, @RequestBody StudentEntity st) {
Optional<StudentEntity> opt = studentService.getOneStudent(id);

if (opt.isPresent()) {
StudentEntity s = opt.get();
s.setName(st.getName());
s.setEmail(st.getEmail());
s.setCgpa(st.getCgpa());
s.setDob(st.getDob());
studentService.insertStudent(s);
return "Updated Successfully ✅";
}
return "Student Not Found ❌";
}

@DeleteMapping("/{id}")
public String deleteStudent(@PathVariable Long id) {
Optional<StudentEntity> st = studentService.getOneStudent(id);
if (st.isPresent()) {
studentService.deleteStudent(id);
return "Deleted Successfully ✅";
}
return "Student Not Found ❌";
}
}
