package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huang
 * @version 1.0
 * @date 2019/03/20 9:35
 **/

public class ForEachTest {
    public static void main(String[] args) {
        // 使用双括弧语法（double-brace syntax）建立并初始化一个List
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

//        for (int i = 0; i < userNames.size(); i++) {
//            if (userNames.get(i).equals("Hollis")) {
//                userNames.remove(i);
//            }
//        }
//        for (String userName : userNames) {
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }

//        Iterator iterator = userNames.iterator();
//        do
//        {
//            if(!iterator.hasNext()){
//                break;
//            }
//            String userName = (String)iterator.next();
//            if(userName.equals("Hollis")){
//                userNames.remove(userName);
//            }
//        } while(true);
        Iterator iterator = userNames.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("Hollis")) {
                iterator.remove();
            }
        }

        System.out.println(userNames);
    }
}
