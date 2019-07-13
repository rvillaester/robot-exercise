package com.robot.validator;

import com.robot.command.Command;

public interface CommandValidator {
    boolean validate(Command command);
}
