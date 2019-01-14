package collectionlearn.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/14 11:23
 **/

public class PriorityQueueLearnTest {
    public static void main(String[] args) {
        final PriorityQueue<Student> queue = new PriorityQueue<>();

        Student s1 = new Student("hbj", 90);
        Student s2 = new Student("gl", 96);
        Student s3 = new Student("ttj", 80);
        Student s4 = new Student("yhl", 85);
        Student s5 = new Student("sqc", 91);

        System.out.println("s2 s3 compare result : " + s2.compareTo(s3));

        queue.add(s1);
        queue.add(s2);
        queue.offer(s3);
        queue.offer(s4);
        queue.offer(s5);
        Object[] students = queue.toArray();

        System.out.println("==================================");
        System.out.println("Students size : " + students.length);
        System.out.println(Arrays.toString(students));

        System.out.println("==================================");
        queue.forEach(System.out::println);

        queue.remove(s2);
        Object[] studentsAfter = queue.toArray();

        System.out.println("==================================");
        System.out.println("After remove students size : " + studentsAfter.length);
        System.out.println(Arrays.toString(studentsAfter));

        System.out.println("==================================");
        queue.forEach(System.out::println);


        System.out.println("==================================");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("==================================");
        System.out.println("after poll queue size : " + queue.size());

    }
}
