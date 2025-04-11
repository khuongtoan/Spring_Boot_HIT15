package com.btvnbuoi4.repositories;

import com.btvnbuoi4.domain.models.AClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AClassRepository extends JpaRepository<AClass, Integer> {

    Optional<AClass> findByName(String name);

    boolean existsByName(String name);
}