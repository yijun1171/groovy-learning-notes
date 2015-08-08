package com.github.yj.groovy.dynamic

def method(String arg){
    return "string"
}

def method(Object arg){
    return "object"
}

Object o = "Object"; //变量o的类型声明为Object 实际上它引用的对象类型是String
def result = method(o); //具体调用哪个函数 是在运行时根据参数的实际类型来决定

assert result.equals("string")