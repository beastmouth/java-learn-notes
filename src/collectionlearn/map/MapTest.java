package collectionlearn.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/05/22 10:08
 **/

public class MapTest {
    public static void main(String[] args) {

    }

    /**
     * 将值中带有Map的Map转换成值中不带有Map的Map，键值以“.”连接
     *
     * @param srcMap 待转换的map
     * @return Map 转换后的map
     */
    public static Map transferMap(Map srcMap) {
        Map<String, Object> resultMap = new HashMap<>();
        transferMap(srcMap, resultMap, "");
        return resultMap;
    }

    private static void transferMap(Map srcMap, Map<String, Object> resultMap, String srcKey) {
        for (Object key : srcMap.keySet()) {
            if ((srcMap.get(key) == null) || (srcMap.get(key).getClass() != java.util.LinkedHashMap.class)) {
                // 如果没有下一级
                if (srcMap.get(key) == null) {
                    resultMap.put(srcKey + key, null);
                } else {
                    resultMap.put(srcKey + key, srcMap.get(key).toString());
                }
            } else {
                transferMap((Map) srcMap.get(key), resultMap, srcKey + key + ".");
            }
        }
    }
}
