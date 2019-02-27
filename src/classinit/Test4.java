package classinit;

/**
 * 重载
 * @author huang
 * @version 1.0
 * @date 2019/02/27 15:22
 **/
abstract class Animal {
}
class Dog extends Animal{
}
class Lion extends Animal{
}
public class Test4 {
    public void run(Animal animal){
        System.out.println("动物跑啊跑");
    }
    public void run(Dog dog){
        System.out.println("小狗跑啊跑");
    }
    public void run(Lion lion){
        System.out.println("狮子跑啊跑");
    }
    //测试
    public static void main(String[] args){
        Animal dog = new Dog();
        Animal lion = new Lion();;
        Test4 test4 = new Test4();
        test4.run(dog);
        test4.run(lion);
    }
}
