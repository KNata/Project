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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewBusCommand implements ICommand {

    private BusDAO busDAO;

    public AddNewBusCommand(BusDAO aBusDAO) {
        busDAO = aBusDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String busID = request.getParameter("idBus");
        String busModel = request.getParameter("busName");
        int maxCountOfPassangers = Integer.parseInt(request.getParameter("maxPassegers"));
        int miles = Integer.parseInt(request.getParameter("miles"));
        boolean passedService = Boolean.parseBoolean(request.getParameter("maintance"));

        if (busID != null && busModel != null && maxCountOfPassangers != 0 && miles != 0) {
            Pattern pattern = Pattern.compile("[A-Z]{3}\\d{6}");
            Matcher matcher = pattern.matcher(busID);
            boolean isMatch = matcher.find();
            if (isMatch) {
                Bus theBus = Bus.newBuilder().setBusID(busID).setBusModel(busModel).setmaxCountOfPassagers(maxCountOfPassangers)
                        .setMiles(miles).setPassedService(passedService).build();
                boolean wasAdded = busDAO.addRecord(theBus);
                ArrayList<Bus> busList = busDAO.findAll();
                request.setAttribute("bus", theBus);
                if (wasAdded) {
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/successPageAdmin.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("/views/adminView/successPageAdmin.jsp");
                }
            } else {
                response.sendRedirect("/views/adminView/errorPageAdmin.jsp");
            }
        }


    }
}
