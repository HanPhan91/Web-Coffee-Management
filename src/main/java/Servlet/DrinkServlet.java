package Servlet;

import DAO.DrinkManagement;
import DAO.IDrinkManagement;
import DAO.IStaffManagement;
import DAO.StaffManagement;
import Enums.PositionEnums;
import Enums.StatusEnums;
import Model.Drink;
import Model.Staff;
import Regex.PhoneNumberInvalid;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/drinks")
public class DrinkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IDrinkManagement iDrink = new DrinkManagement();
    String SAVE_DIR = "/assets/images/drink-img";

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
                removeDrink(req, resp);
                break;
            case "active":
                activeDrink(req, resp);
                break;
            default:
                listDrink(req, resp);
                break;
        }
    }

    private void activeDrink(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean check = false;
        int id = Integer.parseInt(req.getParameter("id"));
        check = iDrink.activeDrink(id);
        resp.sendRedirect(req.getContextPath() + "/drinks?check=" + check);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Drink drink = iDrink.selectDrink(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/drink/editDrink.jsp");
        req.setAttribute("drink", drink);
        dispatcher.forward(req, resp);

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/drink/createDrink.jsp");
        dispatcher.forward(req, resp);
    }

    private void removeDrink(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean check = false;
        int id = Integer.parseInt(req.getParameter("id"));
        check = iDrink.removeDrink(id);
        resp.sendRedirect(req.getContextPath() + "/drinks?check=" + check);
    }

    private void listDrink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Drink> drinkList = iDrink.selectAllDrink();
        String check = req.getParameter("check");
        if (check != null)
            req.setAttribute("check", check);
        req.setAttribute("listDrink", drinkList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/drink/listDrink.jsp");
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
                createDrink(req, resp);
                break;
            case "edit":
                editDrink(req, resp);
                break;
        }
    }

    private void createDrink(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean check = false;
        try {
            String name = req.getParameter("nameDrink");
            long price = Long.parseLong(req.getParameter("priceDrink"));
            String desc = req.getParameter("descDrink");
            Drink newDrink = new Drink(name, price, desc);
            check = iDrink.addDrink(newDrink);
            resp.sendRedirect(req.getContextPath() + "/drinks?check=" + check);
        } catch (Exception ex) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/drink/createDrink.jsp");
            req.setAttribute("check", check);
            dispatcher.forward(req, resp);
        }
    }

    private void editDrink(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean check = false;
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("nameDrink");
            long price = Long.parseLong(req.getParameter("priceDrink"));
            String desc = req.getParameter("descDrink");
            StatusEnums status = StatusEnums.parseStatus(Integer.parseInt(req.getParameter("statusDrink")));
            Drink editDrink = new Drink(id, name, price, desc, status);
            check = iDrink.editDrink(editDrink);
            resp.sendRedirect(req.getContextPath() + "/drinks?check=" + check);
        } catch (Exception ex) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/drink/createDrink.jsp");
            req.setAttribute("check", check);
            dispatcher.forward(req, resp);
        }
    }
}
