
package Servlet;

import DAO.IStaffManagement;
import DAO.IUser;
import DAO.StaffManagement;
import DAO.UserManagement;
import Enums.PositionEnums;
import Enums.StatusEnums;
import Model.Staff;
import Model.User;
import Regex.PhoneNumberInvalid;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(urlPatterns = "/staffs")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IStaffManagement iStaff = new StaffManagement();
    PhoneNumberInvalid regex = new PhoneNumberInvalid();

    @Override
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
                removeStaff(req, resp);
                break;
            default:
                listStaff(req, resp);
                break;
        }
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
                createStaff(req, resp);
                break;
            case "edit":
                editStaff(req, resp);
                break;
        }
    }

    private void createStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameStaff");
        PositionEnums positionEnums = PositionEnums.parsePosition(Integer.parseInt(req.getParameter("positionStaff")));
        String address = req.getParameter("addressStaff");
        String phone = req.getParameter("phoneStaff");
        if (regex.validate(phone)) {
            Staff staff = new Staff(name, positionEnums, address, phone);
            boolean check = iStaff.addStaff(staff);
            resp.sendRedirect(req.getContextPath() + "/staffs?check=" + check);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/staff/createStaff.jsp");
            boolean check = false;
            req.setAttribute("listPosition", PositionEnums.values());
            req.setAttribute("checkRegex", check);
            dispatcher.forward(req, resp);
        }
    }

    private void removeStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUser iUser = new UserManagement();
        int id = Integer.parseInt(req.getParameter("id"));
        boolean check_user= iUser.removeIdByStaff(id);
        boolean check = iStaff.removeStaff(id);
        resp.sendRedirect(req.getContextPath() + "/staffs?check=" + check);
    }

    private void listStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Staff> list = iStaff.selectAllStaff();
        String check = req.getParameter("check");
        if (check != null)
            req.setAttribute("check", check);
        req.setAttribute("listStaff", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/staff/listStaff.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Staff staff = iStaff.selectStaff(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/staff/editStaff.jsp");
        req.setAttribute("position", PositionEnums.values());
        req.setAttribute("staff", staff);
        dispatcher.forward(req, resp);
    }

    private void editStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("nameStaff");
        PositionEnums position = PositionEnums.parsePosition(Integer.parseInt(req.getParameter("positionStaff")));
        String address = req.getParameter("addressStaff");
        String phone = req.getParameter("phoneStaff");
        if (regex.validate(phone)) {
            StatusEnums status = StatusEnums.parseStatus(Integer.parseInt(req.getParameter("statusStaff")));
            Staff editStaff = new Staff(id, name, position, address, phone, status);
            boolean check = iStaff.editStaff(editStaff);
            resp.sendRedirect(req.getContextPath() + "/staffs?check="+ check);
        } else {
            boolean checkRegex = false;
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/staff/editStaff.jsp");
            Staff staff = iStaff.selectStaff(id);
            req.setAttribute("staff", staff);
            req.setAttribute("checkRegex", checkRegex);
            dispatcher.forward(req, resp);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPosition", PositionEnums.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/staff/createStaff.jsp");
        dispatcher.forward(req, resp);
    }
}
