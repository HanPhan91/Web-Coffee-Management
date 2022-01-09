package Enums;

public enum StatusEnums {
    active(1), deactive(0);
    private int value;

    StatusEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusEnums parseStatus(int value) {
        StatusEnums[] values = values();
        for (StatusEnums st : values) {
            if (st.value == value)
                return st;
        }
        throw new IllegalArgumentException("value position invalid");
    }
}
