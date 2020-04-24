package com.liulin.rpcserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class RpcProxyServer {
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    public void publisher(Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                final Socket socket = serverSocket.accept();
                System.out.println("====已链接====");
                executorService.execute(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // TODO
        }
    }
}
