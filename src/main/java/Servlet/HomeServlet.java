package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username= (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/home/home.jsp");
        dispatcher.forward(req,resp);
    }
}
