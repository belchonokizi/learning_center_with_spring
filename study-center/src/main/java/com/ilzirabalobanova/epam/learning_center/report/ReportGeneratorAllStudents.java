package com.ilzirabalobanova.epam.learning_center.report;

import java.util.List;

public class ReportGeneratorAllStudents {

    public String generateReport(List<String> studentsInfo) {
        StringBuilder report = new StringBuilder();
        studentsInfo.forEach(report::append);
        return report.toString();
    }
}
