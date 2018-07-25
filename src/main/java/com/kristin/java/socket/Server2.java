package com.kristin.java.socket;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 22:21
 * @desc 最简单的Server端写入到Client端内容的demo
 * 在浏览器输入localhost:9000  就会在页面显示hello.响应头的部分作为协议内容会被浏览器解析掉所以不会显示在页面
 **/
public class Server2 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        Socket socket = server.accept();
        OutputStream out = socket.getOutputStream();
        out.write("http/1.0 200 OK\nContext-Type:text/html;charset:GBK\n\nhello".getBytes());
        out.flush();
        out.close();
    }
}
