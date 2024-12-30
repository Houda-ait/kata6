package software.ulpgc;

import software.ulpgc.commands.CommandFactory;

public class Main {
    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        new WorkingDaysService(7070, factory).start();
    }
    }

