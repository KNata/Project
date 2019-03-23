package Servlets.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoparkCommand implements ICommand {

    private ICommand command;

    public AutoparkCommand() {}

    public void setCommand (ICommand aCommand){
        command = aCommand;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse responce)  throws IOException, ServletException {
        command.execute(request, responce);
    }
}
