package Servlets.Command.Visitor;

import DAO.RouteDAO;
import DAO.VisitorDAO;
import Model.Visitor;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditVisitorDriverCommand implements ICommand {

    private VisitorDAO visitorDAO;

    public EditVisitorDriverCommand(VisitorDAO aVisitorDAO) {
        visitorDAO = aVisitorDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String driverName = (String) session.getAttribute("driver");
        Visitor theVisitor = visitorDAO.findByLogin(driverName);
        String newDriverPassword = request.getParameter("driverPassword");
        boolean wasUpdated = visitorDAO.update(theVisitor.getVisitorLogin(), newDriverPassword);
        if (wasUpdated) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/successPageAdmin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
