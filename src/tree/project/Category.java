package tree.project;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/24 21:29
 */
public class Category {
    private Integer id;
    private Integer pId;
    private Integer rootId;
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", pId=" + pId +
                ", rootId=" + rootId +
                ", level=" + level +
                '}';
    }

    public Category() {
    }

    public Category(Integer id, Integer pId, Integer rootId, Integer level) {
        this.id = id;
        this.pId = pId;
        this.rootId = rootId;
        this.level = level;
    }
}
