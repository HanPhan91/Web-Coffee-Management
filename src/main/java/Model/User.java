package Model;

import Enums.RoleEnums;
import Enums.StatusEnums;

public class User {
    private int id;
    private String username;
    private String password;
    private RoleEnums role;
    private int idstaff;
    private StatusEnums status;
    String staffName;


    public User(int id, String username, String password, RoleEnums role, int idstaff, String staffName, StatusEnums status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idstaff = idstaff;
        this.staffName = staffName;
        this.status = status;
    }

    public User(String username, String password, RoleEnums role, int idstaff, String staffName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.idstaff = idstaff;
        this.staffName = staffName;
    }
    public User(String username, String password, RoleEnums role, int idstaff) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.idstaff = idstaff;
    }

    public User(String username, String password, RoleEnums role, int idstaff, String staffName, StatusEnums status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.idstaff = idstaff;
        this.staffName = staffName;
        this.status = status;
    }

    public User(int id, String username, String password, RoleEnums roleStatus, int idStaff,StatusEnums statusEnums) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idstaff= idStaff;
        this.status = status;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnums getRole() {
        return role;
    }

    public void setRole(RoleEnums role) {
        this.role = role;
    }

    public int getIdstaff() {
        return idstaff;
    }

    public void setIdstaff(int idstaff) {
        this.idstaff = idstaff;
    }

    public StatusEnums getStatus() {
        return status;
    }

    public void setStatus(StatusEnums status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %d, %s", getId(), getUsername(), getPassword(), getRole(), getIdstaff(), getStatus());
    }
}
