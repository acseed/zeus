package cn.acseed.zeus.common.domain;

/**
 * Created by caohongchen on 16-12-17.
 */
public enum  UserType implements ValuedEnum {
    NOMAL(0, "普通用户"),
    MANAGER(1, "管理员")
    ;

    int value;
    String desc;

    UserType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }
}
