package Model;

import Enums.StatusEnums;

public class Drink {
    private int id;
    private String name;
    private long price;
    private String desc;
    StatusEnums status;

    public Drink() {
    }

    public Drink(String name, long price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public Drink(String name, long price, String desc, StatusEnums status) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.status = status;
    }

    public Drink(int id, String name, long price, String desc, StatusEnums status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.status = status;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public StatusEnums getStatus() {
        return status;
    }

    public void setStatus(StatusEnums status) {
        this.status = status;
    }
}
