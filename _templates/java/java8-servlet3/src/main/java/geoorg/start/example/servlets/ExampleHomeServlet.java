package geoorg.start.example.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class ExampleHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = reqest.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(reqest, response);
    }
}