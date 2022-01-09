package DAO;

import Model.Staff;

import java.util.List;

public interface IStaffManagement {
    public List<Staff> selectAllStaff();
    public List<Staff> selectActiveStaff();
    public Staff selectStaff(int id);
    public boolean addStaff(Staff newStaff);
    public boolean editStaff(Staff editStaff);
    public boolean removeStaff(int id);

}
