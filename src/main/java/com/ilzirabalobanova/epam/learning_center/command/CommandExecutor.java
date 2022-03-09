package com.ilzirabalobanova.epam.learning_center.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandExecutor {
    private final Map<String, Command> commandMap = new HashMap<>();

    private final List<Command> commandList;

    @Autowired
    public CommandExecutor(List<Command> commandList) {
        this.commandList = commandList;
    }

    @PostConstruct
    public void init() {
        commandList.forEach(command -> commandMap.put(command.toString(), command));
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
