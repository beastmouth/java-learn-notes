package collectionlearn.queue;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/14 11:24
 **/

public class Student implements Comparable {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student current = (Student) o;
        if (current.getScore() > this.score) {
            return 1;
        } else if (current.getScore().equals(this.score)) {
            return 0;
        } else {
            return -1;
        }
    }
}
