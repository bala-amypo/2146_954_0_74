package com.example.demo.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;

@Servicepublic 
class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> store = new HashMap<>();
    private long counter = 1;

    @Override
    public Student insertStudent(Student st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Overridepublic List<Student> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    @Overridepublic Optional<Student> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Overridepublic void deleteStudent(Long id) {
        store.remove(id);
    }
}
