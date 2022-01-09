package DAO;

import Model.ListDetail;
import Model.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailManagement implements IOrderDetail{
    ConnectionDAO connectionDAO= null;
    private String SELECT= "select drink.name, drink.price, order_detail.quantity, order_detail.totalPrice from order_detail inner join drink where idDrink= id && idOrder=?;";
    private String ADD= "insert into order_detail(idOrder,idDrink,priceDrink,quantity,totalPrice) values(?,?,?,?,?);";

    @Override
    public List<ListDetail> selectDetail(double idOrder) {
        List<ListDetail> list = new ArrayList<>();
        connectionDAO = new ConnectionDAO();
        try{
            PreparedStatement preparedStatement= connectionDAO.getConnection().prepareStatement(SELECT);
            preparedStatement.setDouble(1,idOrder);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                long price= rs.getLong("price");
                int quantity= rs.getInt("quantity");
                long total= rs.getLong("totalPrice");
                list.add(new ListDetail(name,price,quantity,total));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addDetail(OrderDetail orderDetail) {
        connectionDAO = new ConnectionDAO();
        boolean check=false;
        try{
            PreparedStatement preparedStatement= connectionDAO.getConnection().prepareStatement(ADD);
            preparedStatement.setDouble(1,orderDetail.getIdOrder());
            preparedStatement.setInt(2,orderDetail.getIdDrink());
            preparedStatement.setLong(3,orderDetail.getPriceDrink());
            preparedStatement.setInt(4,orderDetail.getQuantity());
            preparedStatement.setLong(5,orderDetail.getTotalPrice());
            check= preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
