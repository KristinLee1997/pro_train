package com.kristin.java.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 23:13
 * @desc NIO Server
 **/
public class NIOServer {
    private static int BUFFER_SIZE = 1024;
    private static int PORT = 9000;

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannle = serverSocketChannel.accept();
                    socketChannle.configureBlocking(false);
                    socketChannle.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(BUFFER_SIZE));
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buf = (ByteBuffer) key.attachment();
                    // 读浏览器发送的HTTP请求
                    long bytesRead = socketChannel.read(buf);
                    while (bytesRead > 0) {
                        buf.flip();
                        while (buf.hasRemaining()) {
                            System.out.print((char) buf.get());
                        }
                        System.out.println();
                        buf.clear();
                        bytesRead = socketChannel.read(buf);
                    }

                    //向浏览器返回HTTP请求
                    buf.put("http/1.1 200 OK\nContent-Type:text/html;charset:GBK\n\nhello".getBytes());
                    socketChannel = (SocketChannel) key.channel();
                    buf.flip();
                    while (buf.hasRemaining()) {
                        socketChannel.write(buf);
                    }

                    // 关闭
                    socketChannel.close();//这样浏览器才不继续拉取
                    key.cancel();
                }
            }
        }
    }
}
