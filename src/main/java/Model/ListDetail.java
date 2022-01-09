package Model;

public class ListDetail {
    private String name;
    private long price;
    private int quantity;
    private long total;

    public ListDetail() {
    }

    public ListDetail(String name, long price, int quantity, long total) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
