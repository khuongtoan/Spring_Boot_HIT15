package com.buoi3springboot.services;

import com.buoi3springboot.enities.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> searchStudentsByName(String name);
    Optional<Student> findByEmail(String email);
}
