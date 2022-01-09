package Servlet;

import DAO.*;
import Model.Drink;
import Model.ListDetail;
import Model.Order;
import Model.OrderDetail;
import com.mysql.cj.xdevapi.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IOrder iOrder = new OrderManagement();
    private IOrderDetail iOrderDetail = new OrderDetailManagement();
    private IDrinkManagement iDrink = new DrinkManagement();

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
            case "detail":
                showDetail(req, resp);
                break;
            default:
                listOrder(req, resp);
                break;
        }
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Order orderInfo = iOrder.selectOrder(id);
        List<ListDetail> list = iOrderDetail.selectDetail(id);
        req.setAttribute("orderInfo", orderInfo);
        req.setAttribute("listDetail", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/order/orderDetail.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Drink> list = iDrink.selectDrinkActive();
        req.setAttribute("listDrink", list);
        System.out.println(list.size());
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/home/home.jsp");
        dispatcher.forward(req, resp);
    }

    private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> list = iOrder.selectAllOrder();
        req.setAttribute("listOrder", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/order/listOrder.jsp");
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
                createOrder(req, resp);
                break;
        }
    }

    private void createOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idUser = req.getParameter("idU");
        System.out.println(idUser);
        long id = System.currentTimeMillis() / 1000;
        int total_items = Integer.parseInt(req.getParameter("total_items"));
        LocalDateTime date = LocalDateTime.now();
        Order order = new Order(id, date, idUser);
        boolean check_order = iOrder.createOrder(order);
        for (int i = 0; i < total_items; i++) {
            int idDrink = Integer.parseInt(req.getParameter("idDrink" + i));
            int quantity = Integer.parseInt(req.getParameter("quantity" + i));
            long priceDrink = Long.parseLong(req.getParameter("price" + i));
            long total_price = quantity * priceDrink;
            OrderDetail orderDetail = new OrderDetail(id, idDrink, priceDrink, quantity, total_price);
            boolean check_orderdetail = iOrderDetail.addDetail(orderDetail);
        }
        iOrder.updateTotal(id);
        resp.sendRedirect(req.getContextPath() + "/orders?action=detail&id=" + id);
    }
}
