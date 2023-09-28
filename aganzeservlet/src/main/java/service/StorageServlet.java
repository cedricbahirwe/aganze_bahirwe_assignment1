package service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class StorageServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();

        String name = req.getParameter("name");

        if (name.equals("web")) {

            HttpSession session = req.getSession();

            session.setAttribute("username", name);
        } else {
        }

    }
}
