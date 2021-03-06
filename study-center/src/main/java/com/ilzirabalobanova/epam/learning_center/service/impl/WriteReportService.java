package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.report.MultithreadingReportGenerator;
import com.ilzirabalobanova.epam.learning_center.report.ReportGeneratorAllStudents;
import com.ilzirabalobanova.epam.learning_center.service.IWriteReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Service
@Slf4j
public class WriteReportService implements IWriteReportService {
    @Override
    public void writeInFile(String path, List<Student> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(path)) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, list);
        }
        log.info("Отчёт сформирован в src\\main\\resources\\report.txt");
    }

    @Override
    public void writeInFileWithMultithreading(String path, List<Student> list) throws IOException {
        MultithreadingReportGenerator multithreadingGenerator = new MultithreadingReportGenerator();
        ReportGeneratorAllStudents generator = new ReportGeneratorAllStudents();
        List<String> studentInfoForReport = multithreadingGenerator.getStudentInfoForReport(list);
        String lineToWrite = generator.generateReport(studentInfoForReport);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(lineToWrite);
        }
        log.info("Отчёт сформирован в src\\main\\resources\\report.txt");
    }
}
