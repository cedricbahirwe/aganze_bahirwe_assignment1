package service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeExample extends HttpServlet {
    Logger logger = Logger.getLogger(ExampleServlet.class.getName());

    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException, IOException {

        String username, password;
        try {

            PrintWriter pr = resp.getWriter();

            username = req.getParameter("username");
            password = req.getParameter("password");

            pr.println("<h2>Your username is: " + "<u>" + username + "</u>" + " and your password: " + "<u>" + password + "</u>" + "</h2>");

        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error happened " + e.getMessage());
        }
    }
}
