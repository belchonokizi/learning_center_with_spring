package com.ilzirabalobanova.epam.learning_center.command;

import com.ilzirabalobanova.epam.learning_center.command.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommandExecutor {

    private final Map<String, Command> commandMap = new HashMap<>();
    private AddCommand addCommand;
    private ShowAllStudentCommand showAllStudentCommand;
    private CountDaysCommand countDaysCommand;
    private CreateReportCommand createReportCommand;
    private FilterCommand filterCommand;
    private GetScoreCommand getScoreCommand;
    private NotifyCommand notifyCommand;
    private PutMarkCommand putMarkCommand;
    private RemoveCommand removeCommand;

    @PostConstruct
    public void init() {
        commandMap.put("addCommand", addCommand);
        commandMap.put("showAllStudentsCommand", showAllStudentCommand);
        commandMap.put("countDaysCommand", countDaysCommand);
        commandMap.put("createReportCommand", createReportCommand);
        commandMap.put("filterCommand", filterCommand);
        commandMap.put("getScoreCommand", getScoreCommand);
        commandMap.put("notifyCommand", notifyCommand);
        commandMap.put("putMarkCommand", putMarkCommand);
        commandMap.put("removeCommand", removeCommand);

    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    @Autowired
    public void setAddCommand(AddCommand addCommand) {
        this.addCommand = addCommand;
    }

    @Autowired
    public void setShowAllStudentCommand(ShowAllStudentCommand showAllStudentCommand) {
        this.showAllStudentCommand = showAllStudentCommand;
    }

    @Autowired
    public void setCountDaysCommand(CountDaysCommand countDaysCommand) {
        this.countDaysCommand = countDaysCommand;
    }

    @Autowired
    public void setCreateReportCommand(CreateReportCommand createReportCommand) {
        this.createReportCommand = createReportCommand;
    }

    @Autowired
    public void setFilterCommand(FilterCommand filterCommand) {
        this.filterCommand = filterCommand;
    }

    @Autowired
    public void setGetScoreCommand(GetScoreCommand getScoreCommand) {
        this.getScoreCommand = getScoreCommand;
    }

    @Autowired
    public void setNotifyCommand(NotifyCommand notifyCommand) {
        this.notifyCommand = notifyCommand;
    }

    @Autowired
    public void setPutMarkCommand(PutMarkCommand putMarkCommand) {
        this.putMarkCommand = putMarkCommand;
    }

    @Autowired
    public void setRemoveCommand(RemoveCommand removeCommand) {
        this.removeCommand = removeCommand;
    }
}
