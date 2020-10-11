package net.demo.carsrental.controller.servlet.filter;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ERROR})
public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getParameter(ViewConstants.LANGUAGE_PARAM) != null) {
            req.getSession().setAttribute(ViewConstants.LANGUAGE_PARAM, req.getParameter(ViewConstants.LANGUAGE_PARAM));
        }
        if (req.getSession().getAttribute(ViewConstants.LANGUAGE_PARAM) == null) {
            req.getSession().setAttribute(ViewConstants.LANGUAGE_PARAM, ViewConstants.DEFAULT_LANG);
        }
        chain.doFilter(request, response);
    }
}
