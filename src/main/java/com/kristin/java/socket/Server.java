package com.kristin.java.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 18:47
 * @desc 在控制台打印HTTP头部
 * 可以在浏览器输入localhost:9000或者在命令行输入telnet localhost:9000 然后control+],输入send+要在console显示的内容
 **/
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
    }
}