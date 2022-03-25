package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramRepository extends JpaRepository<Program, Integer> {
}
