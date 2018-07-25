package com.kristin.java.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 23:26
 * @desc
 **/
public class NIOClient {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 9000));
        if (socketChannel.finishConnect()) {
            //向服务器写入
            for (int i = 0; i < 3; i++) {
                String info = "hello:<" + i + ">";
                buffer.clear();
                buffer.put(info.getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                }
            }

            //从服务器读取
            buffer.clear();
            long bytesRead = socketChannel.read(buffer);
            while (bytesRead > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                System.out.println();
                buffer.clear();
                bytesRead = socketChannel.read(buffer);
            }
        }
    }
}