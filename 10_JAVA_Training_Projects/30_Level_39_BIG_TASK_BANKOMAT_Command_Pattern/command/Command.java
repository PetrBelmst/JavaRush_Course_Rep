package com.company.command;

import com.company.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;
}
