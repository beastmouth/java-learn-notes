### NIO 网络模型 1：n (非阻塞I/O+Selector)
![NIO](../../images/io/nio/NIO网络模型1.jpg)
##### 一个线程来处理客户端链接
##### 调用两个handler方法来处理链接的创建/读写业务的处理
##### 与BIO的区别：不需要客户端再发送读写请求 减少了服务器性能的消耗
<br/><br/>
#### 核心
##### Channel&nbsp;&nbsp;:&nbsp;通道
##### Buffer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;缓冲区
##### Selector&nbsp;:&nbsp;选择器 或 多路复用器
[介绍链接](https://www.imooc.com/video/19330)
<br/><br/>
* NIO使用Channel
![NIO使用Channel](../../images/io/nio/NIO使用Channel.jpg)
* NIO Buffer介绍
![NIO Buffer 介绍](../../images/io/nio/Buffer的四个属性.jpg)
* NIO Selector的使用
![NIO Selector的使用](../../images/io/nio/Selector的使用.jpg)
![NIO SelectionKey的介绍](../../images/io/nio/SelectionKey介绍.jpg)
<br/><br/>
#### NIO 编程实现步骤
![NIO编程实现步骤1](../../images/io/nio/NIO编程实现步骤1.jpg)
![NIO编程实现步骤2](../../images/io/nio/NIO编程实现步骤2.jpg)
![NIO编程实现步骤3](../../images/io/nio/NIO编程实现步骤3.jpg)
![NIO代码实现1](../../images/io/nio/代码实现1.jpg)
![NIO代码实现2](../../images/io/nio/代码实现2.jpg)