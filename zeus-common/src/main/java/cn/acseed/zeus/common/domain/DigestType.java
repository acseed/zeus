package cn.acseed.zeus.common.domain;

/**
 * Created by caohongchen on 16-12-17.
 */
public enum DigestType implements ValuedEnum {
    NORMAL_TOPIC(0, "普通"),
    MARROW_TOPIC(1, "精华")
    ;

    int value;
    String desc;

    DigestType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return null;
    }

    public int getValue() {
        return 0;
    }
}
