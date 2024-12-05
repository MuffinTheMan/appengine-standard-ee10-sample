package com.test;

import java.io.IOException;
import java.util.logging.Logger;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("*")
public class TestFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(TestFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("doFilter");
        FileInspector.inspectDirectory(".");
        FileInspector.inspectDirectory("/workspace");
        FileInspector.inspectDirectory("/workspace/WEB-INF");
        FileInspector.inspectDirectory("/workspace/java_runtime");
        chain.doFilter(request, response);
    }
}
