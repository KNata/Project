package Servlets.Command.Route;

import DAO.RouteDAO;
import Model.Route;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllRoutesCommand implements ICommand {

    private RouteDAO routeDAO;

    public ShowAllRoutesCommand(RouteDAO aRouteDAO) {
        routeDAO = aRouteDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Route> routeList = routeDAO.findAll();
        if (routeList.size() == 0) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
            dispatcher.forward(request, response);
        }
        String nextJSP = "/views/adminView/seeAllRoutes.jsp";
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
        request.setAttribute("routeList", routeList);
        dispatcher.forward(request, response);
    }
}
