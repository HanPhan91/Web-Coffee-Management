package Servlet;

import DAO.IUser;
import DAO.UserManagement;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServ extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUser iUser = new UserManagement();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher= req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        boolean check=false;
        String username= req.getParameter("username");
        String password=req.getParameter("password");
        check= iUser.checkLogin(username,password);
        if (check == true){
            User user= iUser.selectUserByUsername(username);
            HttpSession session= req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("idUser",user.getId());
            session.setAttribute("role",user.getRole().getValue());
            resp.sendRedirect(req.getContextPath()+ "/orders?action=create");
        }
        else {
            req.setAttribute("check",check);
            RequestDispatcher dispatcher= req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
