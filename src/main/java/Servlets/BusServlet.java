package Servlets;

import DAO.BusDAO;
import Servlets.Command.AutoparkCommand;
import Servlets.Command.Bus.AddNewBusCommand;
import Servlets.Command.Bus.DeleteBus;
import Servlets.Command.Bus.EditBusCommand;
import Servlets.Command.Bus.SeeListOfBuses;
import Servlets.Command.ICommand;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "BusServlet", urlPatterns = "/BusServlet")
public class BusServlet extends HttpServlet {

    private BusDAO busDAO;
    private ICommand currentCommand;
    private AutoparkCommand autoparkCommand;


    public void init() throws ServletException {
        autoparkCommand = new AutoparkCommand();
        busDAO = new BusDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        currentCommand = new SeeListOfBuses(busDAO);
        autoparkCommand.setCommand(currentCommand);
        currentCommand.execute(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "addNewBus":
                currentCommand = new AddNewBusCommand(busDAO);
                autoparkCommand.setCommand(currentCommand);
                currentCommand.execute(request, response);
                break;
            case "editBus":
                currentCommand = new EditBusCommand(busDAO);
                autoparkCommand.setCommand(currentCommand);
                currentCommand.execute(request, response);
                break;
            case "removeBus":
                currentCommand = new DeleteBus(busDAO);
                autoparkCommand.setCommand(currentCommand);
                currentCommand.execute(request, response);
                break;
        }

    }

}
