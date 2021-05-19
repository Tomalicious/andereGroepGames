package com.vdab.commandpattern;

import com.vdab.repositories.NotFoundException;

public interface Command {

    // handig omdat hier polymorfisme van toepassing is , deze kan verschillende gedaantes aan namen daarom gebruik je dit in plaat van een class command kan dan voor
    //meerdere opties gebruikt worden

    void execute() throws Exception, NotFoundException;
}
