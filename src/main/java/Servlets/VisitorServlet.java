package Servlets;


import DAO.VisitorDAO;

import Servlets.Command.AutoparkCommand;
import Servlets.Command.ICommand;
import Servlets.Command.Visitor.AddNewVisitorCommand;
import Servlets.Command.Visitor.DeleteVisitorCommand;
import Servlets.Command.Visitor.EditVisitorCommand;
import Servlets.Command.Visitor.ShowAllVisitorsCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "VisitorServlet", urlPatterns = "/VisitorServlet")
    public class VisitorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private VisitorDAO visitorDAO;
    private ICommand currentCommand;
    private AutoparkCommand autoparkCommand;


    public void init() throws ServletException {
        autoparkCommand = new AutoparkCommand();
        visitorDAO = new VisitorDAO();
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            currentCommand = new ShowAllVisitorsCommand(visitorDAO);
            autoparkCommand.setCommand(currentCommand);
            autoparkCommand.execute(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                case "addNewVisitor":
                    currentCommand = new AddNewVisitorCommand(visitorDAO);
                    autoparkCommand.setCommand(currentCommand);
                    autoparkCommand.execute(request, response);
                    break;
                case "removeVisitor":
                    currentCommand = new DeleteVisitorCommand(visitorDAO);
                    autoparkCommand.setCommand(currentCommand);
                    autoparkCommand.execute(request, response);
                    break;
                case "editAdmin":
                    currentCommand = new EditVisitorCommand(visitorDAO);
                    autoparkCommand.setCommand(currentCommand);
                    autoparkCommand.execute(request, response);
                    break;
            }

        }
}
