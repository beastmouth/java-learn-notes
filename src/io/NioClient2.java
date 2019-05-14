package io;

import java.io.IOException;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/28 19:05
 **/

public class NioClient2 {
    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.start("gl");
    }
}
