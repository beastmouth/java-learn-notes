package classlearn;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/09 17:17
 **/

public class AnonymityTest {
    public static void main(String[] args) {
        //接口，类方法，这些不需要再去创建一个子类或者实现类 去继承或者实现它
        AnonymityClass testClass = new AnonymityClass() {
            @Override
            public void sayHello() {
                System.out.println("Hello ZhuZhu I am a AnonymityClass");
            }
        };
        testClass.sayHello();
    }
}
