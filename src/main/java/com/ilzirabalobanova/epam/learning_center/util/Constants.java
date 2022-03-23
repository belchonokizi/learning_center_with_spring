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
    public static final String FIND_ALL_MODULES_BY_PROGRAM_ID_SQL_QUERY_PATH = "src/main/resources/queries/crud/module/find_all_modules_by_program_id.sql";
    public static final String ADD_MODULE_SQL_QUERY_PATH = "src/main/resources/queries/crud/module/add_module.sql";
    public static final String DELETE_MODULE_SQL_QUERY_PATH = "src/main/resources/queries/crud/module/delete_module.sql";
    public static final String UPDATE_MARK_SQL_QUERY_PATH = "src/main/resources/queries/crud/mark/update_mark.sql";
    public static final String GET_ALL_TEACHERS_SQL_QUERY_PATH = "src/main/resources/queries/crud/teachers/get_all_teachers.sql";
    public static final String ADD_TEACHER_SQL_QUERY_PATH = "src/main/resources/queries/crud/teachers/add_teacher.sql";
    public static final String DELETE_TEACHER_SQL_QUERY_PATH = "src/main/resources/queries/crud/teachers/delete_teacher.sql";
    public static final String FIND_TEACHER_BY_ID_SQL_QUERY_PATH = "src/main/resources/queries/crud/teachers/find_teacher_by_id.sql";
    public static final String LINK_TEACHER_AND_PROGRAM_SQL_QUERY_PATH = "src/main/resources/queries/crud/teachers/link_teacher_and_program.sql";
    public static final String LINK_STUDENT_AND_PROGRAM_SQL_QUERY_PATH = "src/main/resources/queries/crud/mark/add-student-mark.sql";

    private Constants() {
    }
}
