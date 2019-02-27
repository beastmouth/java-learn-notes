package classinit;

/**
 * 重写
 *
 * @author huang
 * @version 1.0
 * @date 2019/02/27 15:42
 **/
abstract class AnimalOverride {
    public abstract void run();
}

abstract class DDDog extends AnimalOverride {

}

class DogOverride extends AnimalOverride {

    @Override
    public void run() {
        System.out.println("小狗跑跑跑！");
    }
}

class CatOverride extends AnimalOverride {

    @Override
    public void run() {
        System.out.println("小猫跑跑跑！");
    }
}

public class Test6 {
    public static void main(String[] args) {
        AnimalOverride dog = new DogOverride();
        AnimalOverride cat = new CatOverride();
        dog.run();
        cat.run();
    }
}
