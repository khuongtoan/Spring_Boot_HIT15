package com.btvnbuoi4.repositories;

import com.btvnbuoi4.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByAclass_Name (String className);
}
