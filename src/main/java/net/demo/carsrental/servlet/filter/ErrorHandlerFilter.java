package net.demo.carsrental.servlet.filter;

import net.demo.carsrental.servlet.ViewNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class ErrorHandlerFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(ErrorHandlerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            chain.doFilter(request, response);
        } catch (Throwable th) {
            String requestUrl = req.getRequestURI();
            LOGGER.error("Request {} failed: {}", requestUrl, th.getMessage(), th);
            req.getRequestDispatcher(ViewNames.ERROR_PAGE).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        //
    }
}