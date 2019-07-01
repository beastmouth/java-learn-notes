package lambdatest;

/**
 * @author hbj
 * @date 2019/7/1 11:31
 */
public class LambdaInterfaceTest {

    public static void main(String[] args) {
        LambdaInterface lambdaInterface = message -> "Hello : " + message;
        System.out.println(lambdaInterface.sayHello("hbj"));
    }
}
