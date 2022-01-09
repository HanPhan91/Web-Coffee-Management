package DAO;

import Model.User;

import java.util.List;

public interface IUser {
    public List<User> selectAllUser();
    public boolean addUser(User newUser);
    public boolean checkUserExist(String username);
    public boolean updateUser(User user);
    public User selectUser(int id);
    public User selectUserByUsername(String username);
    public boolean removeUser(int id);
    public boolean activeUser(int id);
    public List<User> selectUserActive();
    public boolean checkLogin(String username, String password);
    public boolean removeIdByStaff(int idStaff);
}
