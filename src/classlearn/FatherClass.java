package classlearn;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/23 22:34
 **/

public class FatherClass {
    private Integer id;
    private String name;

    public FatherClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void say(String hello) {
        System.out.println("I am father,My number is " + id + " name is " + name + hello);
    }
}
