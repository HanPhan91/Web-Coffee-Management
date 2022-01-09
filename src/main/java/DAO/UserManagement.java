package DAO;

import Enums.RoleEnums;
import Enums.StatusEnums;
import Model.User;

import javax.management.relation.RoleStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagement implements IUser {
    ConnectionDAO connection = null;
    private String SELECTALL = "SELECT * FROM user INNER JOIN staff ON user.idstaff = staff.id;";
    private String ADD = "insert into user(user.username,user.password,user.role,user.idstaff) values(?, ?, ?, ?);";
    private String UPDATE = "UPDATE user SET user.password=?, user.role=? WHERE id=?;";
    private String REMOVE = "UPDATE user SET user.status='0' WHERE id=?;";
    private String ACTIVE = "UPDATE user SET user.status='1' WHERE id=?;";
    private String SELECTACTIVE= "select * from user where user.status='1';";
    private String REMOVEUSER= "UPDATE user SET user.status='0' WHERE idStaff=?;";

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            RoleEnums roleStatus;
            StatusEnums statusEnums;
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                roleStatus = RoleEnums.parseRoleEnums(rs.getInt("role"));
                int idStaff = rs.getInt("idstaff");
                String staffName = rs.getString("name");
                statusEnums = StatusEnums.parseStatus(rs.getInt("status"));
                userList.add(new User(id, username, password, roleStatus, idStaff, staffName, statusEnums));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        userList.sort((o1, o2) -> o2.getStatus().getValue() - o1.getStatus().getValue());
        return userList;
    }

    @Override
    public boolean addUser(User newUser) {
        boolean check = false;
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ADD);
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setInt(3, newUser.getRole().getValue());
            preparedStatement.setInt(4, newUser.getIdstaff());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkUserExist(String username) {
        List<User> listUser = selectAllUser();
        for (User user : listUser) {
            if (user.getUsername().equalsIgnoreCase(username))
                return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        boolean check = false;
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getRole().getValue());
            preparedStatement.setInt(3, user.getId());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public User selectUser(int id) {
        List<User> userList = selectAllUser();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User selectUserByUsername(String username) {
        List<User> userList = selectAllUser();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean removeUser(int id) {
        boolean check = false;
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(REMOVE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean activeUser(int id) {
        boolean check = false;
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ACTIVE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<User> selectUserActive() {
        List<User> list= new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            RoleEnums roleStatus;
            StatusEnums statusEnums;
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTACTIVE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                roleStatus = RoleEnums.parseRoleEnums(rs.getInt("role"));
                int idStaff= rs.getInt("idStaff");
                statusEnums = StatusEnums.parseStatus(rs.getInt("status"));
                list.add(new User(id, username, password, roleStatus, idStaff,statusEnums));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        List<User> listUser= selectUserActive();
        for (User user:listUser) {
            if ((user.getUsername().equals(username)) && (user.getPassword().equals(password)))
                return true;
        }
        return false;
    }

    @Override
    public boolean removeIdByStaff(int idStaff) {
        boolean check = false;
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(REMOVEUSER);
            preparedStatement.setInt(1, idStaff);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
