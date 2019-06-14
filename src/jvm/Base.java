package jvm;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/14 14:51
 **/

public class Base {
    public static String toMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        int freeMemory = (int) (runtime.freeMemory() / 1024 / 1024);
        int totalMemory = (int) (runtime.totalMemory() / 1024 / 1024);
        return freeMemory + "M/" + totalMemory + "M(free/total)";
    }

    public static void main(String[] args) {
        System.out.println("memory info : " + toMemoryInfo());
    }
}
