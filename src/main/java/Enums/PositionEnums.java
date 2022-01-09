package Enums;

public enum PositionEnums {
    manager(1), cashier(2), barista(3), staff(4);
    private int value;

    PositionEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PositionEnums parsePosition(int value) {
        PositionEnums[] values = values();
        for (PositionEnums p : values) {
            if (p.value == value)
                return p;
        }
        throw new IllegalArgumentException("value position invalid");
    }
}
