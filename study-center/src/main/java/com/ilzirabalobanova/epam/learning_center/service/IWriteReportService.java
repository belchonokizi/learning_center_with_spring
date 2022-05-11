package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import java.io.IOException;
import java.util.List;

public interface IWriteReportService {
    void writeInFile(String path, List<Student> list) throws IOException;
    void writeInFileWithMultithreading(String path, List<Student> list) throws IOException, InterruptedException;
}
