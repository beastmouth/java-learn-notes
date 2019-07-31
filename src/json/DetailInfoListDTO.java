package json;


import java.util.List;

/**
 * @author hbj
 * @date 2019/7/31 11:47
 */
public class DetailInfoListDTO {
    private String title;
    private List<DetailInfoDTO> infoList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DetailInfoDTO> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<DetailInfoDTO> infoList) {
        this.infoList = infoList;
    }

    @Override
    public String toString() {
        return "DetailInfoListDTO{" +
                "title='" + title + '\'' +
                ", infoList=" + infoList +
                '}';
    }
}
