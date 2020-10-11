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

/**
 * Filter for Command servlet actions
 */
@WebFilter(ViewConstants.COMMAND_SERVLET_PATH)
public class AccessServletCommandFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AccessServletCommandFilter.class);

    /**
     * Does filter for access to CommandServlet commands
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();
        String path = httpServletRequest.getRequestURL().toString();

        Account.Role roleFromSession = getRoleFromSession(session);
        String commandName = httpServletRequest.getParameter(ViewConstants.ACTION_PARAM);

        if (!allowedCommandAccess(commandName, roleFromSession)) {
            LOGGER.info("Access denied for path '{}' and command '{}' for role '{}' for username '{}'",
                    path, commandName, roleFromSession, session.getAttribute(ViewConstants.USER_NAME));
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + ViewConstants.ACCESS_DENIED_PAGE);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private Account.Role getRoleFromSession(HttpSession session) {
        return (Account.Role) session.getAttribute(ViewConstants.ROLE);
    }

    private boolean allowedCommandAccess(String commandName, Account.Role role) {
        return CommandManager.getInstance()
                             .getCommandNameSet(role)
                             .contains(commandName);
    }
}
