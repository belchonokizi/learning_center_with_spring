package com.ilzirabalobanova.epam.learning_center.command;

import com.ilzirabalobanova.epam.learning_center.exception.*;

public interface Command {

    void execute() throws IllegalInitialDataException;
}
