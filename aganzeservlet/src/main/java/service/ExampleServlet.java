package service;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleServlet implements Filter {
    Logger logger = Logger.getLogger(ExampleServlet.class.getName());

    final static String _username = "web";
    final static String _password = "pass";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        String username, password;
        try {

            PrintWriter pr = servletResponse.getWriter();

            username = servletRequest.getParameter("username");
            password = servletRequest.getParameter("password");

            if (username.equals(_username) && password.equals(_password)) {
                servletResponse.setContentType("text/html");
                logger.log(Level.INFO, "You have authenticated");

                pr.print("<h1>You are authenticated</h1>");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error happened " + e.getMessage());
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }


    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException, IOException {

        String username, password;
        try {

            PrintWriter pr = resp.getWriter();

            username = req.getParameter("username");
            password = req.getParameter("password");
            pr.println("Your username is " + username + " and password: " + password);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error happened " + e.getMessage());
        }
    }
}
