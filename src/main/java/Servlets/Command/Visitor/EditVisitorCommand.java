package Servlets.Command.Visitor;

import DAO.VisitorDAO;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditVisitorCommand implements ICommand {

    private VisitorDAO visitorDAO;

    public EditVisitorCommand(VisitorDAO aVisitorDAO) {
        visitorDAO = aVisitorDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String visitorLogin = request.getParameter("visitorLogin");
        String passwodToChange = request.getParameter("visitorPassword");
        String visitorRole = request.getParameter("visitorRole");

        boolean wasEdited = visitorDAO.updateForAdmin(visitorLogin, passwodToChange, visitorRole);
        if (wasEdited) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/adminMainPage.jsp");
            dispatcher.forward(request, response);
            System.out.println("done");
        }
    }
}
