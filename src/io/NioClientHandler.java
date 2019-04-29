package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/28 19:22
 **/

public class NioClientHandler implements Runnable {
    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            // 6. 循环等待新接入的链接
            for (; ; ) {
                // 当没有channel的时候 也会有空轮询 造成cpu占用率100%
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                // 获取可用的channel集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    // 获取selectionKey实例
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    // **移除Set中当前的selectionKey**
                    iterator.remove();

                    // 7. 根据就绪状态，调用对应方法处理业务逻辑
                    // 如果是 可读事件
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        // 要从selectionKey中获取到已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        // 创建buffer（来操作读）
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环读取服务端端请求信息
        String response = "";
        while (socketChannel.read(byteBuffer) > 0) {
            // 此时byteBuffer是写入状态，要切换成读模式
            byteBuffer.flip();

            // 读取buffer中的内容
            response += Charset.forName("UTF-8").decode(byteBuffer);
        }

        // 将Channel注册到selector上，监听他的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 将服务器端响应信息打印到本地
        if (response.length() > 0) {
            System.out.println(response);
        }
    }
}
