package com.btvnbuoi4.repositories;

import com.btvnbuoi4.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByAclass_Id(Integer classId);

}
