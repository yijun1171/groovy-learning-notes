package com.github.yj.groovy.mp

//方法拦截
//1.实现GroovyInterceptable接口
//2.在metaClass中重写invokeMethod

class Interception implements GroovyInterceptable{

    def definedMethod(){}

    def invokeMethod(String name, Object value){
        "intercepted"
    }
}

Interception interception = new Interception()
assert interception.definedMethod() == "intercepted"
assert interception.somemethod() == "intercepted"


class MetaInterception {

    def definedMethod(){
        "defined"
    }
}

MetaInterception i = new MetaInterception();
i.metaClass.invokeMethod = {String name, Object value ->
    "intercepted"
}

assert i.definedMethod() == "intercepted"