package DAO;

import Model.ListDetail;
import Model.OrderDetail;

import java.util.List;

public interface IOrderDetail {
    public List<ListDetail> selectDetail(double idOrder);
    public boolean addDetail(OrderDetail orderDetail);
}
