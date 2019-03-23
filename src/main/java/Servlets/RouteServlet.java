package Servlets;

import DAO.BusDAO;
import DAO.DriverDAO;
import DAO.RouteDAO;
import Model.Bus;
import Model.Driver;
import Model.Route;
import Servlets.Command.AutoparkCommand;
import Servlets.Command.Bus.SeeListOfBuses;
import Servlets.Command.ICommand;
import Servlets.Command.Route.AddNewRouteRommand;
import Servlets.Command.Route.DeleteRouteCommand;
import Servlets.Command.Route.EditRouteCommand;
import Servlets.Command.Route.ShowAllRoutesCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "RouteServlet", urlPatterns = "/RouteServlet")
public class RouteServlet extends HttpServlet {

    private RouteDAO routeDAO;
    private ICommand currentCommand;
    private AutoparkCommand autoparkCommand;


    public void init() throws ServletException {
        routeDAO = new RouteDAO();
        autoparkCommand = new AutoparkCommand();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        currentCommand = new ShowAllRoutesCommand(routeDAO);
        autoparkCommand.setCommand(currentCommand);
        autoparkCommand.execute(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "addNewRoute":
                currentCommand = new AddNewRouteRommand(routeDAO);
                autoparkCommand.setCommand(currentCommand);
                autoparkCommand.execute(request, response);
                break;
            case "removeRoute":
                currentCommand = new DeleteRouteCommand(routeDAO);
                autoparkCommand.setCommand(currentCommand);
                autoparkCommand.execute(request, response);
                break;
            case "edit":
                currentCommand = new EditRouteCommand(routeDAO);
                autoparkCommand.setCommand(currentCommand);
                autoparkCommand.execute(request, response);
                break;
        }

    }

}
