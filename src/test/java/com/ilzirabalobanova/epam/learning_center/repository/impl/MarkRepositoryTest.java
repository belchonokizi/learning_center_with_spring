package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCMarkRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaMarkRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/marks/marks-schema.sql", "/marks/marks-test-data.sql"})
class MarkRepositoryTest {
    @Autowired
    private JpaMarkRepository markRepository;

    private final Mark mark1 = new Mark(1, 1, 1, 80);
    private final Mark mark2 = new Mark(2, 1, 2, 70);
    private final Mark mark3 = new Mark(1, 1, 1, 60);

    @Test
    void findStudentMarks() {
        List<Mark> resultList = markRepository.findStudentMarks(1);
        assertThat(resultList, hasSize(2));
        assertThat(resultList, hasItem(mark1));
        assertThat(resultList, hasItem(mark2));
    }

    @Test
    void updateMark() {
        assertTrue(markRepository.updateMark(1, 1, 60));
        List<Mark> resultList = markRepository.findStudentMarks(1);
        assertThat(resultList, hasItem(mark3));
    }
}