package com.kristin.java.socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 22:33
 * @desc 最简单的Client端写入到Server端的Demo
 **/
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9000);
        OutputStream output = socket.getOutputStream();
        output.write("你好".getBytes());
        output.close();
        socket.close();
    }
}
