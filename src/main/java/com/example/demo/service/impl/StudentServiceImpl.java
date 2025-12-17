package com.example.demo.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.Studentservice;

@Service
public class StudentServiceImpl implements Studentservice {

    private final Map<Integer, StudentEntity> store = new HashMap<>();
    private int counter = 1;

    @Override
    public StudentEntity insertStudent(StudentEntity st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<StudentEntity> getOneStudent(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(int id) {
        store.remove(id);
    }
}