
package DAO;
import Enums.PositionEnums;
import Enums.StatusEnums;
import Model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StaffManagement implements IStaffManagement {
    ConnectionDAO connection = null;
    private String SELECTALL = "select * from staff;";
    private String SELECTACTIVE= "select * from staff where status='1';";
    private String ADD= "insert into staff(name,position,address,sdt) values(?, ?, ?, ?);";
    private String UPDATE= "UPDATE staff SET name=?, position=?, address=?, sdt=? WHERE id=?;";
    private String REMOVE= "UPDATE staff SET status=? WHERE id=?;";

    public List<Staff> selectAllStaff() {
        PositionEnums positionEnums;
        StatusEnums statusEnums;
        List<Staff> staffList = new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int position = rs.getInt("position");
                String address = rs.getString("address");
                String phone=rs.getString("sdt");
                int status = rs.getInt("status");
                positionEnums = PositionEnums.parsePosition(position);
                statusEnums= StatusEnums.parseStatus(status);
                staffList.add(new Staff(id, name, positionEnums, address, phone,statusEnums));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        staffList.sort((o1, o2) -> o2.getStatus().getValue() - o1.getStatus().getValue());
        return staffList;
    }

    @Override
    public List<Staff> selectActiveStaff() {
        PositionEnums positionEnums;
        StatusEnums statusEnums;
        List<Staff> staffList = new ArrayList<>();
        try {
            connection = new ConnectionDAO();
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECTACTIVE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int position = rs.getInt("position");
                String address = rs.getString("address");
                String phone=rs.getString("sdt");
                int status = rs.getInt("status");
                positionEnums = PositionEnums.parsePosition(position);
                statusEnums= StatusEnums.parseStatus(status);
                staffList.add(new Staff(id, name, positionEnums, address, phone,statusEnums));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        staffList.sort((o1, o2) -> o2.getStatus().getValue() - o1.getStatus().getValue());
        return staffList;
    }

    @Override
    public Staff selectStaff(int idStaff) {
        List<Staff> staffList= selectAllStaff();
        for (Staff staff : staffList) {
            if (staff.getId() == idStaff) {
                return staff;
            }
        }
        return null;
    }

    @Override
    public boolean addStaff(Staff newStaff) {
        boolean check= false;
        connection= new ConnectionDAO();
        try {
            PreparedStatement preparedStatement= connection.getConnection().prepareStatement(ADD);
            preparedStatement.setString(1,newStaff.getName());
            preparedStatement.setInt(2, newStaff.getPosition().getValue());
            preparedStatement.setString(3,newStaff.getAddress());
            preparedStatement.setString(4,newStaff.getPhone());
            check= preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean editStaff(Staff editStaff) {
        boolean check=false;
        connection= new ConnectionDAO();
        try{
            PreparedStatement preparedStatement= connection.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1,editStaff.getName());
            preparedStatement.setInt(2, editStaff.getPosition().getValue());
            preparedStatement.setString(3, editStaff.getAddress());
            preparedStatement.setString(4, editStaff.getPhone());
            preparedStatement.setInt(5, editStaff.getId());
            check= preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean removeStaff(int id) {
        boolean check = false;
        connection= new ConnectionDAO();
        try{
            PreparedStatement preparedStatement= connection.getConnection().prepareStatement(REMOVE);
            preparedStatement.setString(1,"0");
            preparedStatement.setInt(2, id);
            check= preparedStatement.executeUpdate() >0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
}
