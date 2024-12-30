package software.ulpgc.commands;

import software.ulpgc.model.WorkCalendar;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDaysCommand implements Command{
    private final Input input;
    private final Output output;

    public WorkingDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        Iterator<LocalDate> iterator = new
                WorkCalendar().iteratorFor(input.start());
        LocalDate current = input.start();
        int workingDays = 0;
        while (current.isBefore(input.end())) {
            workingDays++;
            current = iterator.next();         }
        output.workingDays(workingDays);}

    public interface Input{
        LocalDate start();
        LocalDate end();
    }

    public interface Output{
        void workingDays(int days);
    }
}
