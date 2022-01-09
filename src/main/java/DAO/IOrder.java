package DAO;

import Model.Order;

import java.util.List;

public interface IOrder {
    public List<Order> selectAllOrder();
    public Order selectOrder(long id);
    public boolean createOrder(Order newOrder);
    public void  updateTotal(long id);

}
