package com.github.yj.groovy.dynamic;

/**
 * Created by yijun.yj on 2015/8/8.
 */
public class DynamicTest {

    public String method(String arg){
        return "String";
    }

    public String method(Object arg){
        return "Object";
    }

    public static void main(String[] args){
        DynamicTest test = new DynamicTest();
        Object o = "test";
        String result = test.method(o);
        System.out.print(result);
    }
}
