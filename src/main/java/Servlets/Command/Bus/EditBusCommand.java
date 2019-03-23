package Servlets.Command.Bus;

import DAO.BusDAO;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditBusCommand implements ICommand {

    private BusDAO busDAO;

    public EditBusCommand(BusDAO aBusDAO) {
        busDAO = aBusDAO;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String busID = request.getParameter("idBus");
        int miles = Integer.parseInt(request.getParameter("miles"));
        boolean passedService = Boolean.parseBoolean(request.getParameter("passedService"));
        System.out.println("idBus " + busID);
        System.out.println("miles " + miles);
        System.out.println("passedService " + passedService);
        boolean wasUpdated = busDAO.update(busID, miles, passedService);
        System.out.println("wasUpdated " + wasUpdated);
        if (wasUpdated) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/successPageAdmin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/adminView/errorPageAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
