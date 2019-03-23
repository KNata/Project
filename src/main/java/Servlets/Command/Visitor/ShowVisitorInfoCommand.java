package Servlets.Command.Visitor;

import DAO.RouteDAO;
import DAO.VisitorDAO;
import Model.Route;
import Model.Visitor;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShowVisitorInfoCommand implements ICommand {

    private RouteDAO routeDAO;
    private VisitorDAO visitorDAO;

    public ShowVisitorInfoCommand(VisitorDAO aVisitorDAO, RouteDAO aRouteDAO) {
        routeDAO = aRouteDAO;
        visitorDAO = aVisitorDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("driver"));
        VisitorDAO visitorDAO = new VisitorDAO();
        Visitor theVisitor = visitorDAO.findByLogin((String)session.getAttribute("driver"));
        routeDAO.setDriverID(theVisitor.getTheDriver().getDriverID());
        System.out.println(theVisitor.getTheDriver().getDriverID());
        ArrayList<Route> driverStoryList = routeDAO.showDriverInfo();
        System.out.println(driverStoryList.size());
        System.out.println(driverStoryList.toArray() + "\n");

        if (driverStoryList.size() == 0) {
            System.out.println("1");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/driverView/errorPageDriver.jsp");
            dispatcher.forward(request, response);
            System.out.println("2");
        } else {
            System.out.println("3");
            request.setAttribute("routeStoryList", driverStoryList);
            System.out.println("4");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/userView/seeMyRoutes.jsp");
            dispatcher.forward(request, response);
        }

    }
}
