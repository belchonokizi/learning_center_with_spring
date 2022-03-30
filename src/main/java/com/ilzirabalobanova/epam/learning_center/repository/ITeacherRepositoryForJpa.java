package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITeacherRepositoryForJpa extends PagingAndSortingRepository<Teacher, Integer>, ITeacherRepository {
}
