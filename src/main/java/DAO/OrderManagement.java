package DAO;

import Model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement implements IOrder{
    private ConnectionDAO connectionDAO= null;
    private String SELECTALL= "select * from coffee_managementweb.order;";
    private String SELECT= "select * from coffee_managementweb.order where id=?;";
    private String ADD= "insert into coffee_managementweb.order(id,createAt,username) values(?,?,?);";
    private String UPDATETOTAL= "update coffee_managementweb.order set total= (select sum(totalPrice) from order_detail where idOrder=?) where id=?;";
    @Override
    public List<Order> selectAllOrder() {
        List<Order> list= new ArrayList<>();
        connectionDAO= new ConnectionDAO();
        try{
            PreparedStatement preparedStatement = connectionDAO.getConnection().prepareStatement(SELECTALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                long id= resultSet.getLong("id");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime date= LocalDateTime.parse(resultSet.getString("createAt"),formatter);
                String idUser= resultSet.getString("username");
                long total= resultSet.getLong("total");
                list.add(new Order(id,date,idUser,total));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Order selectOrder(long id) {
        connectionDAO= new ConnectionDAO();
        Order order= null;
        try{
            PreparedStatement preparedStatement= connectionDAO.getConnection().prepareStatement(SELECT);
            preparedStatement.setLong(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                long idOrder= rs.getLong("id");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime date= LocalDateTime.parse(rs.getString("createAt"),formatter);
                String idUser= rs.getString("username");
                long total= rs.getLong("total");
                order = new Order(idOrder,date,idUser,total);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean createOrder(Order newOrder) {
        boolean check = false;
        connectionDAO= new ConnectionDAO();
        try{
            PreparedStatement preparedStatement= connectionDAO.getConnection().prepareStatement(ADD);
            preparedStatement.setLong(1,newOrder.getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(newOrder.getCreateAt()));
            preparedStatement.setString(3,newOrder.getIdUser());
            check= preparedStatement.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public void updateTotal(long id) {
        connectionDAO= new ConnectionDAO();
        try{
            PreparedStatement preparedStatement= connectionDAO.getConnection().prepareStatement(UPDATETOTAL);
            preparedStatement.setLong(1,id);
            preparedStatement.setLong(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
