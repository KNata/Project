package Servlets.Command.Visitor;

import DAO.VisitorDAO;
import Model.Visitor;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllVisitorsCommand implements ICommand {

    private VisitorDAO visitorDAO;

    public ShowAllVisitorsCommand(VisitorDAO aVisitorDAO) {
        visitorDAO = aVisitorDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Visitor> visitorList = visitorDAO.findAll();
        System.out.println(visitorList.size());
        if (visitorList.size() == 0) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("visitorList", visitorList);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/allVisitors.jsp");
            dispatcher.forward(request, response);
        }
    }
}
