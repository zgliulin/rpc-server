package com.liulin.rpcserver;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayHello(String content) {
        return "Hello content:"+content;
    }
}
