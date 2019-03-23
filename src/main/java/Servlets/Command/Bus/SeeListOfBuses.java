package Servlets.Command.Bus;

import DAO.BusDAO;
import Model.Bus;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SeeListOfBuses implements ICommand {

    private BusDAO busDAO;

    public SeeListOfBuses(BusDAO aBusDAO) {
        busDAO = aBusDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Bus> busList = busDAO.findAll();
        if (busList.size() == 0) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
            dispatcher.forward(request, response);
        } else {
            String nextJSP = "/views/adminView/seeAllBuses.jsp";
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
            request.setAttribute("busList", busList);
            dispatcher.forward(request, response);
        }
    }
}
