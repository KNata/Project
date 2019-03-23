package Servlets.Command.Route;

import DAO.RouteDAO;
import Model.Route;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteRouteCommand implements ICommand {

    private RouteDAO routeDAO;

    public DeleteRouteCommand(RouteDAO aRouteDAO) {
        routeDAO = aRouteDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String routeID = request.getParameter("idRoute");
        System.out.println("idRoute " + routeID);
        if (routeID != null && routeDAO.findByID(routeID) != null) {
            System.out.println("1");
            boolean wasDeleted = routeDAO.deleteRecord(routeID);
            System.out.println(wasDeleted + "was deleted");
            if (wasDeleted) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/successPageAdmin.jsp");
                dispatcher.forward(request, response);
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Done.</font>");
                dispatcher.include(request, response);
            } else {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
                dispatcher.forward(request, response);
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Fail.</font>");
                dispatcher.include(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/deleteRoute.jsp");
            dispatcher.forward(request, response);
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Fail.</font>");
            dispatcher.include(request, response);
        }
    }
}
