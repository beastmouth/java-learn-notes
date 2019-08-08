package json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Json逐层解析
 *
 * @author hbj
 * @date 2019/7/31 11:45
 */
public class JsonAnalysis {
    public static void main(String[] args) {
        String jsonStr = "[{\"title\":\"MacBookPro256G溯源信息\",\"infoList\":[{\"key\":\"溯源信息\",\"value\":[{\"key\":\"MacBookPro256G溯源信息\",\"type\":3,\"value\":[{\"key\":\"制造商\",\"value\":\"梨子科技\",\"type\":0},{\"key\":\"基本信息\",\"type\":3,\"value\":[{\"key\":\"价格\",\"type\":0,\"value\":\"17000\"},{\"key\":\"产地\",\"type\":0,\"value\":\"杭州复杂美\"},{\"key\":\"产品图\",\"type\":2,\"value\":\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\"},{\"key\":\"产品图\",\"type\":3,\"value\":[\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\",\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\"]}]}]}],\"type\":3}]},{\"title\":\"MacBookPro256G溯源信息\",\"infoList\":[{\"key\":\"溯源信息\",\"value\":[{\"key\":\"MacBookPro256G溯源信息\",\"type\":3,\"value\":[{\"key\":\"制造商\",\"value\":\"梨子科技\",\"type\":0},{\"key\":\"基本信息\",\"type\":3,\"value\":[{\"key\":\"价格\",\"type\":0,\"value\":\"17000\"},{\"key\":\"产地\",\"type\":0,\"value\":\"杭州复杂美\"},{\"key\":\"产品图\",\"type\":2,\"value\":\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\"},{\"key\":\"产品图\",\"type\":3,\"value\":[\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\",\"http://114.55.11.139:1082/fdfs/test/M00/00/5B/rBBkE1ztAMCAXzmaAAgvvzwpJ7o884.jpg\"]}]}]}],\"type\":3}]}]";
        List<DetailInfoListDTO> list = JSON.parseArray(jsonStr, DetailInfoListDTO.class);
        List<DetailInfoListDTO> resultList = new ArrayList<>();
        for (DetailInfoListDTO detailInfoListDTO : list) {
            List<DetailInfoDTO> infoList = detailInfoListDTO.getInfoList();
            List<DetailInfoDTO> resultDetailInfoDTO = new ArrayList<>();
            for (DetailInfoDTO detailInfoDTO : infoList) {
                DetailInfoDTO detailInfoDTO1 = analysisDetailInfo(detailInfoDTO);
                resultDetailInfoDTO.add(detailInfoDTO1);
            }
            DetailInfoListDTO detailInfoListDTOResult = new DetailInfoListDTO();
            detailInfoListDTOResult.setTitle(detailInfoListDTO.getTitle());
            detailInfoListDTOResult.setInfoList(resultDetailInfoDTO);
            resultList.add(detailInfoListDTOResult);
        }
        String jsonString = JSON.toJSONString(resultList);
        System.out.println(jsonString);
        System.out.println(resultList.toString());
    }

    public static DetailInfoDTO analysisDetailInfo(DetailInfoDTO detailInfoDTO) {
        String jsonStr = detailInfoDTO.getValue().toString();
        try {
            List<DetailInfoDTO> detailInfoDTOSNew = new ArrayList<>();
            List<DetailInfoDTO> detailInfoDTOS = JSON.parseArray(jsonStr, DetailInfoDTO.class);
            for (DetailInfoDTO detailInfoDTOKid : detailInfoDTOS) {
                DetailInfoDTO detailInfo = analysisDetailInfo(detailInfoDTOKid);
                detailInfo.setType(null);
                detailInfoDTOSNew.add(detailInfo);
            }
            detailInfoDTO.setValue(detailInfoDTOSNew);
        } catch (Exception e) {
            System.out.println("转化失败");
            detailInfoDTO.setValue(detailInfoDTO.getValue().toString());
        }
        return detailInfoDTO;
    }
}
