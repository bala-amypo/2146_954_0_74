package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.StudentEntity;

public interface Studentservice {

    StudentEntity insertStudent(StudentEntity st);

    List<StudentEntity> getAllStudents();

    Optional<StudentEntity> getOneStudent(int id);

    void deleteStudent(int id);
}
