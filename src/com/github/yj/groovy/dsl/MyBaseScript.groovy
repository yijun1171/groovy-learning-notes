package com.github.yj.groovy.dsl


/**
 * Created by yijun.yj on 2015/8/26.
 * 脚本基类
 */
abstract class MyBaseScript extends Script{

    int count = 0

    //该方法体由脚本内容来实现
    abstract void scriptBody()

    @Override
    Object run() {
        count++
        scriptBody()
        count
    }

    def name
    def greet(){
        "hello ${name}"
    }
}
