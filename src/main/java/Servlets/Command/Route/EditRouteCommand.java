package Servlets.Command.Route;

import DAO.BusDAO;
import DAO.DriverDAO;
import DAO.RouteDAO;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditRouteCommand implements ICommand {

    private RouteDAO routeDAO;

    public EditRouteCommand(RouteDAO aRouteDAO) {
        routeDAO = aRouteDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String routeID = request.getParameter("idRoute");
        String busID = request.getParameter("busID");
        String driverID = request.getParameter("driverID");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        int duration = Integer.valueOf(request.getParameter("routeDuration"));

        System.out.println("Route ID " + routeID);
        System.out.println("Bus ID " + busID);
        System.out.println("Driver ID " + driverID);
        System.out.println("departureTime " + departureTime);
        System.out.println("arrivalTime " + arrivalTime);
        System.out.println("duration " + duration);

        BusDAO busDAO = new BusDAO();
        DriverDAO driverDAO = new DriverDAO();
        if (routeID != null && busID != null && driverID != null && departureTime != null && arrivalTime != null
                && duration != 0 && busDAO.findByID(busID) != null && driverDAO.findByID(driverID) != null && routeDAO.findByID(routeID) != null) {
            boolean wasUpdated = routeDAO.update(Integer.valueOf(routeID), driverID, busID, departureTime, arrivalTime, duration);
            System.out.println(wasUpdated);
            if (wasUpdated) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/successPage.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
                dispatcher.forward(request, response);
                System.out.println("Error because update procedure was failed");
            }
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
            dispatcher.forward(request, response);
            System.out.println("Error inside verification block");
        }
    }
}
