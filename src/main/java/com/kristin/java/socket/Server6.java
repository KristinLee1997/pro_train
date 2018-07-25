package com.kristin.java.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 23:08
 * @desc 伪异步IO, 为了避免Server5无限制地开一个新线程, 使用线程池来统一管理线程.
 **/
public class Server6 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("服务端启动");
        ExecutorService pool = Executors.newFixedThreadPool(40);
        // 循环着监听
        while (true) {
            Socket s = ss.accept();
            System.out.println("接收到客户端");
            // 一旦接收到客户端,就放入线程池
            pool.submit(() -> {
                //为了让代码简短,try多包一些代码...
                try {
                    InputStream input = s.getInputStream();
                    OutputStream output = s.getOutputStream();
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
                    output.write("http/1.1 200 OK\nContent-Type:text/html;charset:GBK\n\nhello".getBytes());
                    output.flush();
                    input.close();
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //...其实close应该出现在这里...
                    System.out.println("断开连接");
                }
            });
        }
    }
}