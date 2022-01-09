package Enums;

public enum RoleEnums {
    admin(1), user(2);
    private int value;

    RoleEnums(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static RoleEnums parseRoleEnums(int value){
        RoleEnums[] values = values();
        for (RoleEnums rl: values) {
            if (rl.value == value)
                return rl;
        }
        throw new IllegalArgumentException("value position invalid");
    }
}
