package com.kristin.java.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 22:50
 * @desc 将服务器改为循环运行
 **/
public class Server4 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9000);
        while (true) {
            Socket s = ss.accept();
            InputStream input = s.getInputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                int len = input.read(bytes);
                // 如果读到了内容,说明得输出啊
                if (len > 0) {
                    System.out.println(new String(bytes, 0, len));
                }
                // 如果没读取到内容,或者没读满bytes数组 说明读完了, 不用再读下一次了, 该退出循环了.
                if (len < bytes.length) {
                    break;
                }
            }
        }
    }
}
