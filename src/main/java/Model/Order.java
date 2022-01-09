package Model;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private LocalDateTime createAt;
    private String idUser;
    private long total;

    public Order() {
    }

    public Order(long id, LocalDateTime createAt, String idUser, long total) {
        this.id = id;
        this.createAt = createAt;
        this.idUser = idUser;
        this.total = total;
    }

    public Order(long id, LocalDateTime createAt, String idUser) {
        this.id = id;
        this.createAt = createAt;
        this.idUser = idUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
