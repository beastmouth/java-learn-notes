package lambdatest;

import po.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author huang
 * @version 1.0
 * @date 2018/12/29 10:23
 **/

public class ConsumerTest {
    public static void main(String[] args) {
//        Consumer<Integer> consumer = x ->{
//            int a = x + 2;
//            System.out.println(a);
//        };
//        consumer.accept(10);

//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
//        Consumer<int[]> consumer = x -> {
//            System.out.println(Arrays.toString(x));
//        };
//        consumer.accept(array);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        Consumer<List<Integer>> consumer = x ->{
//            x.forEach(System.out::print);
//        };
//        consumer.accept(list);
//
//        Function<List<Integer>, Boolean> function = y ->{
//            return y.contains(3);
//        };
//        Boolean result = function.apply(list);

        System.out.println("===============================");
        list.forEach(System.out::print);
        Function<List<Integer>, List<Integer>> function1 = y -> {
//            y.forEach(number -> number = number > 5 ? 5 : number);
//            System.out.println();
//            y.forEach(System.out::print);
//            return y;
//            1.Stream是元素的集合，这点让Stream看起来用些类似Iterator；
//            2.可以支持顺序和并行的对原Stream进行汇聚的操作
            return y.stream().map(number -> {
                return number > 5 ? 5 : number;}).collect(Collectors.toList());
        };
        List<Integer> resultList = function1.apply(list);
        System.out.println();
        resultList.forEach(System.out::print);
        System.out.println();
        System.out.println("===============================");
        long countBiggerThan6 = list.stream().filter(num -> num > 6).count();
        List<Integer> sortResultList = list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }).collect(Collectors.toList());
        System.out.println();
        sortResultList.forEach(System.out::print);
        System.out.println();
        System.out.println("countBiggerThan6 num size is " + countBiggerThan6);

        Supplier<User> supplier = () -> new User("ZhuZhu", 22);
        User user = supplier.get();
//        Consumer<User> consumer = x -> System.out::println;
        System.out.println("User info : name is " + user.getName() + " age is " + user.getAge());



//        System.out.println("result：" + result);
//
//        Function<List<Integer>, String> function2 = y ->{
//            return y.contains(99) ? "have" : "do not have";
//        };
//
//        String checkContains = function2.apply(list);
//        System.out.println("checkContains：" + checkContains);
//
//
//
//        User gl = new User();
//        gl.setName("gl");
//        gl.setAge(22);
//        User hbj = new User();
//        hbj.setName("hbj");
//        hbj.setAge(23);
//
//        User[] users = new User[]{gl, hbj};
//        Arrays.datastructure.sort(users, Comparator.comparing(User::getName));
//        Arrays.asList(users).forEach(System.out::println);

    }

    Comparator<User> byName = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<User> byNameLambda = (User u1, User u2) -> u1.getName().compareTo(u2.getName());

    Comparator<User> byNameLambdaSimple = Comparator.comparing(User::getName);

}
