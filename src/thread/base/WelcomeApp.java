package thread.base;

/**
 * @author huang
 * @version 1.0
 * @date 2019/03/07 11:12
 **/

public class WelcomeApp {
    public static void main(String[] args) {
        Thread welcomeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2.Welcome! I am " + Thread.currentThread().getName());
            }
        });

        welcomeThread.start();
        welcomeThread.run();
        welcomeThread.run();
        System.out.println("1.Welcome! I am " + Thread.currentThread().getName());
    }
}
