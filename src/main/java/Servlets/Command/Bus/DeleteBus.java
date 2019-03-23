package Servlets.Command.Bus;

import DAO.BusDAO;
import Servlets.Command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBus implements ICommand {

    private BusDAO busDAO;

    public DeleteBus(BusDAO aBusDAO) {
        busDAO = aBusDAO;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String busID = request.getParameter("idBus");
        System.out.println(busID);
        boolean wasDeleted = busDAO.deleteRecord(busID);
        System.out.println("wasDeleted " + wasDeleted);
        if (wasDeleted) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/successPage.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/commonView/errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
