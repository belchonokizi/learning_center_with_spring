package com.ilzirabalobanova.epam.learning_center.report;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MultithreadingReportGenerator {
    private final ExecutorService service = Executors.newFixedThreadPool(5);
    private static final Logger LOGGER = LoggerFactory.getLogger(MultithreadingReportGenerator.class);

    public List<String> getStudentInfoForReport(List<Student> studentList) {
        ReportGeneratorStudent generator = new ReportGeneratorStudent();
        List<Future<String>> futures = studentList.stream()
                .map(generator::toReportTask)
                .map(service::submit)
                .collect(Collectors.toList());

        return futures.stream().map(this::unwrapFuture).collect(Collectors.toList());
    }

    private <T> T unwrapFuture(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Ошибка получения информации о студентах {}", e.getMessage());
        }
        return null;
    }
}
