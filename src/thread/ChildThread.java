package thread;

import java.util.concurrent.Callable;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:37
 **/

public class ChildThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(" do something 1");
        exceptionMethod();
        System.out.println(" do something 2");
        return " test result";
    }

    private void exceptionMethod(){
        throw new RuntimeException(" ChildThread exception");
    }
}
