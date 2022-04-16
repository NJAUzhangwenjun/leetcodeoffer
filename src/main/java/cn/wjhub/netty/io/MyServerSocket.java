package cn.wjhub.netty.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/4/420:31
 */
public class MyServerSocket {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(9000);
    while (true) {
      Socket accept = serverSocket.accept();
      handle(accept);
    }
  }

  private static void handle(Socket accept) throws IOException {
    byte[] bytes = new byte[1024];
    int read;
    while ((read= accept.getInputStream().read(bytes)) != -1) {
      System.out.println(new String(bytes,0,read));
    }
    bytes.clone();
    accept.close();
  }
}
