package classlearn;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/23 22:34
 **/

public class KidClass extends FatherClass {
    private Integer age;

    public KidClass(Integer id, String name, Integer age) {
        super(id, name);
        this.age = age;
    }

    @Override
    public void say(String hello) {
        super.say(hello);
        System.out.println("I am " + age + " years old");
    }
}
