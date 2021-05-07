package com.vdab.commandpattern;

import com.vdab.repositories.NotFoundException;

public interface Command {

    void execute() throws Exception, NotFoundException;
}
