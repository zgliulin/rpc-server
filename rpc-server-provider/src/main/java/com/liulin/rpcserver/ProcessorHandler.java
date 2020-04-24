package com.liulin.rpcserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class ProcessorHandler implements Runnable {
    Socket socket;
    Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            // 可以拿到哪些信息？需要哪些信息
            RpcRequest request = (RpcRequest)inputStream.readObject();
            Object result = invoke(request);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // TODO
        }
    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName(request.getClassName());
        Method method = clazz.getMethod(request.getMethodName(),request.getTypes());
        Object result = method.invoke(service, request.getParameters());
        return result;
    }
}
