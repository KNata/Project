package Servlets.Command.Driver;

import DAO.DriverDAO;
import Model.Driver;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllDriversCommand implements ICommand {

    private DriverDAO driverDAO;

    public ShowAllDriversCommand(DriverDAO aDriverDAO) {
        driverDAO = aDriverDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Driver> driverList = driverDAO.findAll();
        System.out.println(driverList.size());
        if (driverList.size() == 0) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("driverList", driverList);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/seeAllDrivers.jsp");
            dispatcher.forward(request, response);
        }
    }
}
