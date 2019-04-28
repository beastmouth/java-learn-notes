package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/28 17:54
 **/

public class NioServer {

    public void start() throws IOException {
        // 1. 创建Selector
        Selector selector = Selector.open();

        // 2. 通过ServerSocketChannel创建channel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 3. 为channel通道绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));

        // 4. ** 设置channel为非阻塞模式 **
        serverSocketChannel.configureBlocking(false);

        // 5. 将channel注册到selector上，监听链接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");

        // 6. 循环等待新接入的链接
        for (; ; ) {
            // TODO 获取可用channel数量
            int readyChannels = selector.select();
            // TODO 为什么要这样做
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
                // 如果是 接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }
                // 如果是 可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        // 如果是接入事件，创建socketChannel(与客户端连接的channel)
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 将socketChannel设置为非阻塞工作模式
        socketChannel.configureBlocking(false);

        // 将socketChannel注册到selector上，监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 回复客户端提示信息（建立好链接）
        socketChannel.write(Charset.forName("UTF-8").encode("你与聊天室其他人都不是朋友关系，请注意隐私安全"));
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        // 要从selectionKey中获取到已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        // 创建buffer（来操作读）
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环读取客户端请求信息
        String request = "";
        while (socketChannel.read(byteBuffer) > 0) {
            // 此时byteBuffer是写入状态，要切换成读模式
            byteBuffer.flip();

            // 读取buffer中的内容
            request += Charset.forName("UTF-8").decode(byteBuffer);
        }

        // 将Channel注册到selector上，监听他的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 将客户端发送的请求信息（读取和解析） 广播给其他客户端
        if (request.length() > 0) {
            // 广播给其他客户端
            socketChannel.write(Charset.forName("UTF-8").encode(request));
            broadCast(selector, socketChannel, request);
        }
    }

    /**
     * 广播给其他客户端
     */
    private void broadCast(Selector selector, SocketChannel sourceChannel, String request) {
        // 获取所有已接入的客户端channel
        Set<SelectionKey> selectionKeySet = selector.keys();

        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();

            // 剔除发消息的客户端
            if (targetChannel instanceof SocketChannel && targetChannel != sourceChannel) {
                try {
                    // 将信息发送到targetChannel客户端
                    ((SocketChannel) targetChannel).write(Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // 循环向所有channel广播信息
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.start();
    }
}
