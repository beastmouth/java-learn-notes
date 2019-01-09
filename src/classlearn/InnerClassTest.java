package classlearn;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/09 17:19
 **/

public class InnerClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer("zhuzhu");
        outer.zhu();
        Outer.StaticClass staticClass = new Outer.StaticClass();
        staticClass.sayHello();
//        Outer.Inner inner = outer.new Inner();
//        inner.sayHello();

    }
}
