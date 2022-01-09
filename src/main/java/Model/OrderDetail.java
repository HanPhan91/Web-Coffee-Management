package Model;

public class OrderDetail {
    private long idOrder;
    private int idDrink;
    private long priceDrink;
    private int quantity;
    private long totalPrice;

    public OrderDetail() {
    }

    public OrderDetail(long idOrder, int idDrink, long priceDrink, int quantity, long totalPrice) {
        this.idOrder = idOrder;
        this.idDrink = idDrink;
        this.priceDrink = priceDrink;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public double getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public long getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(long priceDrink) {
        this.priceDrink = priceDrink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
