package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.ProgramRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.StudentRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.service.impl.ProgramService;
import com.ilzirabalobanova.epam.learning_center.service.impl.StudentService;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandFactory {

    @Autowired
    private static IStudentService iStudentService;
    @Autowired
    private static IProgramService programService;

    private CommandFactory() {
    }

    public static Command createAddCommand() {
        return new AddCommand(iStudentService, programService);
    }

    public static Command createRemoveCommand() {
        return new RemoveCommand(iStudentService);
    }

    public static Command createPutMarkCommand() {
        return new PutMarkCommand(iStudentService, programService);
    }

    public static Command createCountDaysCommand() {
        return new CountDaysCommand(iStudentService, programService);
    }

    public static Command createGetScoreCommand() {
        return new GetScoreCommand(iStudentService, programService);
    }

    public static Command createNotifyCommand() {
        return new NotifyCommand(iStudentService, programService);
    }

    public static Command createShowAllStudentsCommand() {
        return new ShowAllStudentCommand(iStudentService);
    }

    public static Command createFilterCommand() {
        return new FilterCommand(iStudentService);
    }

    public static Command createReportCommand() {
        return new CreateReportCommand(iStudentService);
    }

}
