package com.ilzirabalobanova.epam.learning_center.util;

public class Constants {
    public static final String PATH_STUDENT_FILE = "src/main/resources/students.json";
    public static final String PATH_YAML_FILE = "src/main/resources/properties.yaml";
    public static final String PATH_REPORT = "src/main/resources/report.txt";
    public static final int PASSING_SCORE = 75;
    public static final double HOURS_IN_DAY = 24.0;
    public static final String REGEX_NON_DIGITS_AND_PUNCT = "(\\d?+\\p{Punct}?)+";
    public static final String GET_ALL_STUDENTS_QUERY_PATH = "src/main/resources/queries/crud/student/find_all_info_about_students.sql";
    public static final String ADD_STUDENT_QUERY_PATH = "src/main/resources/queries/crud/student/add_student.sql";
    public static final String DELETE_STUDENT_BY_ID_SQL_QUERY_PATH = "src/main/resources/queries/crud/student/delete_student.sql";
    public static final String GET_STUDENT_BY_ID_SQL_QUERY_PATH = "src/main/resources/queries/crud/student/find_student_by_id.sql";
    public static final String UPDATE_STUDENT_SQL_QUERY_PATH = "src/main/resources/queries/crud/student/update_student.sql";
    public static final String GET_ALL_PROGRAMS_SQL_QUERY_PATH = "src/main/resources/queries/crud/program/find_all_programs.sql";
    public static final String ADD_PROGRAM_SQL_QUERY_PATH = "src/main/resources/queries/crud/program/add_program.sql";
    public static final String DELETE_PROGRAM_SQL_QUERY_PATH = "src/main/resources/queries/crud/program/delete_program.sql";
    public static final String FIND_PROGRAM_BY_ID_SQL_QUERY_PATH = "src/main/resources/queries/crud/program/find_program_by_id.sql";


    private Constants() {
    }
}
