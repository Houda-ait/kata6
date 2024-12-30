package software.ulpgc.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.commands.WorkingDateCommand;
import software.ulpgc.commands.WorkingDaysCommand;

import java.io.IOException;
import java.time.LocalDate;

public class WorkingDaysAdapter {
    public static WorkingDaysCommand.Input inputOf(HttpServletRequest request) {
        return new WorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.getParameter("start"));
            }
            @Override
            public LocalDate end() {
                return LocalDate.parse(request.getParameter("end"));
            }
        };
    }

    public static WorkingDaysCommand.Output outputOf(HttpServletResponse response) {
        return days -> {
            try {response.getWriter().write(String.valueOf(days));
                response.setStatus(200);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}