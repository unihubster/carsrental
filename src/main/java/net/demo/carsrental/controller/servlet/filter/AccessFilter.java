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

@WebFilter("/*")
public class AccessFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AccessFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

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

        if (isCommandServletCall(path) && !allowedCommandAccess(commandName, roleFromSession)) {
            LOGGER.info("Access denied for path '{}' and command '{}' for role '{}' for username '{}'",
                    path, commandName, roleFromSession, session.getAttribute(ViewConstants.USER_NAME));
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + ViewConstants.ACCESS_DENIED_PAGE);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        //
    }

    private Account.Role getRoleFromSession(HttpSession session) {
        return (Account.Role) session.getAttribute(ViewConstants.ROLE);
    }

    private boolean allowedCommandAccess(String commandName, Account.Role role) {
        return CommandManager.getInstance()
                             .getCommandNameSet(role)
                             .contains(commandName);
    }

    private boolean isCommandServletCall(String path) {
        return path.contains(ViewConstants.COMMAND_SERVLET_PATH);
    }
}
