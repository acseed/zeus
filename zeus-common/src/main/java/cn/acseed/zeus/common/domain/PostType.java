package cn.acseed.zeus.common.domain;

/**
 * Created by caohongchen on 16-12-17.
 */
public enum  PostType implements ValuedEnum {
    MAIN_POST(0, "主帖子"),
    REPLAY_POST(1, "回复")
    ;

    int value;
    String desc;

    PostType(int value, String desc) {
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
