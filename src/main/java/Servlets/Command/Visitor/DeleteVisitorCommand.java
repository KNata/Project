package Servlets.Command.Visitor;

import DAO.VisitorDAO;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteVisitorCommand implements ICommand {

    private VisitorDAO visitorDAO;

    public DeleteVisitorCommand(VisitorDAO aVisitorDAO) {
        visitorDAO = aVisitorDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String visitorID = request.getParameter("visitorID");
        System.out.println("idVisitor " + visitorID);
        boolean wasFound = visitorDAO.findByID(visitorID);
        System.out.println("wasFound " + wasFound);
        if (visitorID != null && wasFound) {
            boolean wasDeleted = visitorDAO.deleteRecord(visitorID);
            System.out.println("wasDeleted " + wasDeleted);
            if (wasDeleted) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/successPageAdmin.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
