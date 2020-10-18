package net.demo.carsrental.controller.servlet.filter;

import net.demo.carsrental.controller.command.CommandManager;
import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Filter for Command servlet actions
 */
@WebFilter(filterName = "AccessGatewayServletFilter",
        urlPatterns = {ViewConstants.COMMAND_SERVLET_PATH, ViewConstants.COMMAND_SERVLET_PATH + "/*"})
public class AccessGatewayServletFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AccessGatewayServletFilter.class);
    private static final CommandManager COMMAND_MANAGER = CommandManager.getInstance();

    /**
     * Does filter for access to CommandServlet commands
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String path = req.getRequestURL().toString();

        Account.Role roleFromSession = getRoleFromSession(session);
        String commandName = COMMAND_MANAGER.getCommandName(req);

        if (isAllowedCommandAccess(commandName, roleFromSession)) {
            filterChain.doFilter(req, res);
        } else {
            LOGGER.info("Access denied for path '{}' and command '{}' for role '{}' and username '{}'",
                    path, commandName, roleFromSession, session.getAttribute(ViewConstants.USER_NAME));
            res.setStatus(HttpURLConnection.HTTP_FORBIDDEN);
            res.sendRedirect(req.getContextPath() + ViewConstants.ACCESS_DENIED_PAGE);
        }
    }

    private Account.Role getRoleFromSession(HttpSession session) {
        return (Account.Role) session.getAttribute(ViewConstants.ROLE);
    }

    private boolean isAllowedCommandAccess(String commandName, Account.Role role) {
        return COMMAND_MANAGER
                .getCommandNameSet(role)
                .contains(commandName);
    }
}
