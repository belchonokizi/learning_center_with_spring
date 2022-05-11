package com.ilzirabalobanova.epam.learning_center.report;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class ReportGeneratorStudent {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGeneratorStudent.class);

    public Callable<String> toReportTask(Student student) {
        return () -> {
            Thread.sleep(1000);
            LOGGER.info(Thread.currentThread().getName());
            return student.toString();
        };
    }
}
