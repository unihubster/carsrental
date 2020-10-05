package net.demo.carsrental.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static net.demo.carsrental.servlet.ViewParameters.DEFAULT_LANG;
import static net.demo.carsrental.servlet.ViewParameters.LANGUAGE_PARAM;

@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ERROR})
public class LocaleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getParameter(LANGUAGE_PARAM) != null) {
            req.getSession().setAttribute(LANGUAGE_PARAM, req.getParameter(LANGUAGE_PARAM));
        }
        if (req.getSession().getAttribute(LANGUAGE_PARAM) == null) {
            req.getSession().setAttribute(LANGUAGE_PARAM, DEFAULT_LANG);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //
    }
}
