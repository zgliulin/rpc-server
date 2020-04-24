package com.liulin.rpcserver;

import java.io.Serializable;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class RpcRequest implements Serializable {
    private String className;
    private String methodName;
    private Object[] parameters;
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
