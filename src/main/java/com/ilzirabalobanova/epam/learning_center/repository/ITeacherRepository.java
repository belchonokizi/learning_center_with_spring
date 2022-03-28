package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITeacherRepository extends PagingAndSortingRepository<Teacher, Integer> {
}
