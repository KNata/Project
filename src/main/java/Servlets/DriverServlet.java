package Servlets;

import DAO.BusDAO;
import DAO.DriverDAO;
import Model.Driver;
import Servlets.Command.AutoparkCommand;
import Servlets.Command.Bus.SeeListOfBuses;
import Servlets.Command.Driver.ShowAllDriversCommand;
import Servlets.Command.ICommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "DriverServlet", urlPatterns = "/DriverServlet")
public class DriverServlet extends HttpServlet {

    private static Logger theLogger;

    private DriverDAO driverDAO;
    private ICommand currentCommand;
    private AutoparkCommand autoparkCommand;

    public void init() throws ServletException {
        autoparkCommand = new AutoparkCommand();
        driverDAO = new DriverDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        currentCommand = new ShowAllDriversCommand(driverDAO);
        autoparkCommand.setCommand(currentCommand);
        currentCommand.execute(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
