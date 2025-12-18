package com.example.demo.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService {

private final Map<Long, StudentEntity> store = new HashMap<>();
private long counter = 1;

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
public Optional<StudentEntity> getOneStudent(Long id) {
return Optional.ofNullable(store.get(id));
}

@Override
public void deleteStudent(Long id) {
store.remove(id);
}
}
