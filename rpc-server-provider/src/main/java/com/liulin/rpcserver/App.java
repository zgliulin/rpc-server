package com.liulin.rpcserver;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        IHelloService service = new HelloServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publisher(service,8888);
    }
}
