package com.github.yj.groovy.mp

//Category

class Target {

    def store(String o){
        println("store:" + o)
    }
}

class PrintCategory{

    //必须声明为static
    //第一个参数必须是方法应用的目标
    static void storeAll(Target t, String[] value ){
        value.each {t.store(it)}
    }
}

Target t = new Target()

//动态增强方法
use(PrintCategory){
    t.storeAll("hello","world")
}


