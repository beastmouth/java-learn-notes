package classinit;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/27 15:28
 **/

public class Test5 {
    //    public static void sayHello(Object arg){
//        System.out.println("hello Object");
//    } 6
//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    } 2
//    public static void sayHello(long arg){
//        System.out.println("hello long");
//    } 3
//    public static void sayHello(Character arg){
//        System.out.println("hello Character");
//    } 4
//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    } 1
    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }   //7

    //    public static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    } 5
    //测试
    public static void main(String[] args) {
        char a = 'a';
        sayHello('a');
    }
}
