package Servlets;

import DAO.RouteDAO;
import DAO.VisitorDAO;
import Model.Driver;
import Model.Route;
import Model.Visitor;
import Servlets.Command.AutoparkCommand;
import Servlets.Command.ICommand;
import Servlets.Command.Visitor.EditVisitorDriverCommand;
import Servlets.Command.Visitor.ShowVisitorInfoCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "RouteDriverServlet", urlPatterns = "/RouteDriverServlet")
public class RouteDriverServlet extends HttpServlet {

    private RouteDAO routeDAO;
    private VisitorDAO visitorDAO;
    ;
    private ICommand currentCommand;
    private AutoparkCommand autoparkCommand;


    public void init() throws ServletException {
        autoparkCommand = new AutoparkCommand();
        visitorDAO = new VisitorDAO();
        routeDAO = new RouteDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        currentCommand = new ShowVisitorInfoCommand(visitorDAO, routeDAO);
        autoparkCommand.setCommand(currentCommand);
        autoparkCommand.execute(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "editDriver":
                currentCommand = new EditVisitorDriverCommand(visitorDAO);
                autoparkCommand.setCommand(currentCommand);
                autoparkCommand.execute(request, response);
                break;
        }
    }




    }
