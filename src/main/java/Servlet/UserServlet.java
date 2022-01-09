package Servlet;

import DAO.IStaffManagement;
import DAO.IUser;
import DAO.StaffManagement;
import DAO.UserManagement;
import Enums.PositionEnums;
import Enums.RoleEnums;
import Enums.StatusEnums;
import Model.Staff;
import Model.User;
import Regex.PhoneNumberInvalid;

import javax.management.relation.Role;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUser iUser = new UserManagement();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username= (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "remove":
                removeUser(req, resp);
                break;
            case "active":
                activeUser(req, resp);
                break;
            default:
                listUser(req, resp);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStaffManagement iStaff = new StaffManagement();
        List<Staff> listStaff = iStaff.selectActiveStaff();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/createUser.jsp");
        req.setAttribute("listStaff", listStaff);
        req.setAttribute("listRole", RoleEnums.values());
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User userEdit = iUser.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/editUser.jsp");
        req.setAttribute("role", RoleEnums.values());
        req.setAttribute("userEdit", userEdit);
        dispatcher.forward(req, resp);
    }

    private void activeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean check = iUser.activeUser(id);
        resp.sendRedirect(req.getContextPath() + "/users?check=" + check);
    }

    private void removeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean check = iUser.removeUser(id);
        resp.sendRedirect(req.getContextPath() + "/users?check=" + check);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = iUser.selectAllUser();
        String check = req.getParameter("check");
        if (check != null)
            req.setAttribute("check", check);
        req.setAttribute("userList", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/listUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username= (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                createUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean check = false;
        String username = req.getParameter("username");
        if (iUser.checkUserExist(username)) {
            boolean userFalse = false;
            req.setAttribute("userFalse", userFalse);
            showCreateForm(req,resp);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/createUser.jsp");
//            dispatcher.forward(req,resp);
        } else {
            String password = req.getParameter("password");
            String password_repeat = req.getParameter("password-repeat");
            if (password.equals(password_repeat)) {
                int idStaff = Integer.parseInt(req.getParameter("nameStaff"));
                RoleEnums role = RoleEnums.parseRoleEnums(Integer.parseInt(req.getParameter("role")));
                User newUser= new User(username,password,role,idStaff);
                System.out.println(newUser.getRole().getValue());
                check = iUser.addUser(newUser);
                req.setAttribute("check", check);
                resp.sendRedirect("/users?check="+check);
            }
            else {
                boolean passFalse = false;
                req.setAttribute("passFalse", passFalse);
                showCreateForm(req,resp);
//                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/createUser.jsp");
//                dispatcher.forward(req, resp);
            }
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RoleEnums role = RoleEnums.parseRoleEnums(Integer.parseInt(req.getParameter("roleUser")));
        StatusEnums status = StatusEnums.parseStatus(Integer.parseInt(req.getParameter("statusUser")));
        String staffName = req.getParameter("staffName");
        int idStaff = Integer.parseInt(req.getParameter("idStaff"));
        User editUser = new User(id, username, password, role, idStaff, staffName, status);
        boolean check = iUser.updateUser(editUser);
        resp.sendRedirect(req.getContextPath() + "/users?check=" + check);
    }

}
