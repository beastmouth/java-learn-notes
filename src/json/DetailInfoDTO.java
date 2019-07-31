package json;

/**
 * @author hbj
 * @date 2019/7/31 11:47
 */
public class DetailInfoDTO {
    private String key;
    private Object value;
    private Integer type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DetailInfoDTO{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
