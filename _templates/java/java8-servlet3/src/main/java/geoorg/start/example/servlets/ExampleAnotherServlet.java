package geoorg.start.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gaw on 7/3/2018.
 */
@WebServlet("/another")
public class ExampleAnotherServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("some_attr", "some_attr value");
        req.getRequestDispatcher("another.jsp").forward(req, resp);
    }
}
