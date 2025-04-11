package com.btvnbuoi4.repositories;

import com.btvnbuoi4.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByAclass_Id(Integer classId);

}
