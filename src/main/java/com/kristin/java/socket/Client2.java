package com.kristin.java.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/21 22:39
 * @desc 最简单的用Client端来模拟浏览器http请求Demo
 **/
public class Client2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.sohu.com", 80);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        StringBuilder str = new StringBuilder();
        //http协议中请求行,必须,不然不会被识别为HTTP
        str.append("GET / HTTP/1.1\r\n");
        //http协议中的请求头
        str.append("Host: www.sohu.com\r\n");
        str.append("Connection: Keep-Alive\r\n");
        // 用于模拟浏览器的user-agent
        str.append("user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36\r\n");
        //这里一定要一个回车换行，表示消息头完，不然服务器会一直等待,认为客户端没发送完
        str.append("\r\n");
        byte[] bytes = new byte[1024];
        output.write(str.toString().getBytes());
        while (true) {
            int len = input.read(bytes);
            if (len > 0) {
                String result = new String(bytes, 0, len);
                System.out.println(result);
            } else {
                break;
            }
        }
    }
}
