package DAO;

import Enums.PositionEnums;
import Enums.StatusEnums;
import Model.Drink;
import Model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrinkManagement implements IDrinkManagement {
    ConnectionDAO connection = null;
    private String SELECTALL = "select * from drink;";
    private String SELECTACTIVE = "select * from drink where status='1';";
    private String ADD = "insert into drink(drink.name,drink.price,drink.desc) values(?, ?, ?);";
    private String UPDATE = "UPDATE drink SET drink.name=?, drink.price=?, drink.desc=? WHERE drink.id=?;";
    private String REMOVE = "UPDATE drink SET status='0' WHERE id=?;";
    private String ACTIVE = "UPDATE drink SET status='1' WHERE id=?;";

    @Override
    public List<Drink> selectAllDrink() {
        StatusEnums statusEnums;
        List<Drink> drinkList = new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long price = rs.getLong("price");
                String desc = rs.getString("desc");
                int status = rs.getInt("status");
                statusEnums = StatusEnums.parseStatus(status);
                drinkList.add(new Drink(id, name, price, desc, statusEnums));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        drinkList.sort((o1, o2) -> o2.getStatus().getValue() - o1.getStatus().getValue());
        return drinkList;
    }

    @Override
    public List<Drink> selectDrinkActive() {
        StatusEnums statusEnums;
        List<Drink> drinkList = new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTACTIVE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long price = rs.getLong("price");
                String desc = rs.getString("desc");
                int status = rs.getInt("status");
                statusEnums = StatusEnums.parseStatus(status);
                drinkList.add(new Drink(id, name, price, desc, statusEnums));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return drinkList;
    }

    @Override
    public Drink selectDrink(int id) {
        List<Drink> drinkList = selectAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getId() == id) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public boolean addDrink(Drink newDrink) {
        boolean check = false;
        connection = new ConnectionDAO();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ADD);
            preparedStatement.setString(1, newDrink.getName());
            preparedStatement.setLong(2, newDrink.getPrice());
            preparedStatement.setString(3, newDrink.getDesc());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean editDrink(Drink editDrink) {
        boolean check = false;
        connection = new ConnectionDAO();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1, editDrink.getName());
            preparedStatement.setLong(2, editDrink.getPrice());
            preparedStatement.setString(3, editDrink.getDesc());
            preparedStatement.setInt(4, editDrink.getId());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean removeDrink(int id) {
        boolean check = false;
        connection = new ConnectionDAO();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(REMOVE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean activeDrink(int id) {
        boolean check = false;
        connection = new ConnectionDAO();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ACTIVE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
}
