package basicknowledge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hbj
 * @date 2019/8/30 18:08
 */
public class StringLearn {
    public static void main(String[] args) {
        String str = "boo:and:foo";
//        replaceStr(str);
        split(str);

    }

    /**
     * 字符串替换测试
     *
     * @param str 字符串
     */
    private static void replaceStr(String str) {
        System.out.println("替换之前：" + str);
        // 字符只能一个
        String replace1 = str.replace(':', ' ');
        System.out.println(replace1);
        // 字符串能多个-即是一个String
        String replace2 = str.replace(":", " ");
        System.out.println(replace2);
        String replace3 = str.replaceAll(":", " ");
        System.out.println(replace3);
        String replace4 = str.replaceFirst(":", " ");
        System.out.println(replace4);
    }

    private static void split(String str) {
        String[] split1 = str.split(":");
        List<String> stringList1 = Arrays.asList(split1);
        System.out.println(" 第一次拆分");
        stringList1.forEach(s -> System.out.print(" " + s));
        String[] split2 = str.split(":", 2);
        List<String> stringList2 = Arrays.asList(split2);
        System.out.println("\n 第二次拆分");
        stringList2.forEach(s -> System.out.print(" " + s));
        String[] split3 = str.split(":", 5);
        List<String> stringList3 = Arrays.asList(split3);
        System.out.println("\n 第三次拆分");
        stringList3.forEach(s -> System.out.print(" " + s));
        String[] split4 = str.split(":",-2);
        List<String> stringList4 = Arrays.asList(split4);
        System.out.println("\n 第四次拆分");
        stringList4.forEach(s -> System.out.print(" " + s));
        String[] split5 = str.split("o");
        List<String> stringList5 = Arrays.asList(split5);
        System.out.println("\n 第五次拆分");
        stringList5.forEach(s -> System.out.print(" " + s));
        String[] split6 = str.split("o",2);
        List<String> stringList6 = Arrays.asList(split6);
        System.out.println("\n 第六次拆分");
        stringList6.forEach(s -> System.out.print(" " + s));
    }
}
