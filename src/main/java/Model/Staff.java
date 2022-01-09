package Model;

import Enums.PositionEnums;
import Enums.StatusEnums;

public class Staff {
    private int id;
    private String name;
    private PositionEnums position;
    private String address;
    private String phone;
    private StatusEnums status;

    public Staff(int id, String name, double price, String desc, String img, StatusEnums status) {
    }

    public Staff(int id, String name, PositionEnums position, String address, String phone, StatusEnums status) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.address = address;
        this.phone= phone;
        this.status = status;
    }

    public Staff(String name, PositionEnums position, String address, String phone) {
        this.name = name;
        this.position = position;
        this.address = address;
        this.phone= phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionEnums getPosition() {
        return position;
    }

    public void setPosition(PositionEnums position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusEnums getStatus() {
        return status;
    }

    public void setStatus(StatusEnums status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s", getId(), getName(), getPosition(), getAddress(), getPhone(),getStatus());
    }
}
