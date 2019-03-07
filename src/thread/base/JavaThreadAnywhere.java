package thread.base;

/**
 * @author huang
 * @version 1.0
 * @date 2019/03/07 14:40
 **/

public class JavaThreadAnywhere {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        String currentThreadName = currentThread.getName();
        System.out.println("The main method was executed by thread:" + currentThreadName);
        Helper2 helper = new Helper2();
        helper.start();
    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message) {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();
            System.out.println("The doSomething method was executed by thread:" + currentThreadName);
            System.out.println("The doSomething with " + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }

    static class Helper2 extends Thread {

        private void doSomething() {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();
            System.out.println("The doSomething method was executed by thread:" + currentThreadName);
        }

        @Override
        public void run() {
            doSomething();
        }
    }
}
