package net.demo.carsrental.controller.servlet;

import net.demo.carsrental.controller.command.Command;
import net.demo.carsrental.controller.command.CommandConstants;
import net.demo.carsrental.controller.command.CommandManager;
import net.demo.carsrental.controller.util.ContextUsersHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ViewConstants.COMMAND_SERVLET_PATH})
public class ServletCommand extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ServletCommand.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ContextUsersHandler.initLoggedUsers(config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Request {}", req.getRequestURI());
        Command command = CommandManager.getInstance().getCommand(req);
        String page = command.execute(req);
        if (page.contains(CommandConstants.REDIRECT_COMMAND)) {
            resp.sendRedirect(page.replace(CommandConstants.REDIRECT_COMMAND, req.getContextPath()));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}
