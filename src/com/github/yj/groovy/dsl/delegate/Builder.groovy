package com.github.yj.groovy.dsl.delegate

import groovy.transform.TypeChecked

//用delegate特性和Builder模式创造一种小型DSL

class Email{
    String from
    String to
    String subject
    Body body

    void from(String f){
        println "FROM:${f}"
        from = f
    }

    void to(String t){
        println "TO:${t}"
        to = t
    }

    void subject(String s){
        println "SUBJECT:${s}"
        subject = s
    }

    void body(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Body) Closure c){
        Body body = new Body()
        def code = c.rehydrate(body, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY //改变优先级
        code() //调用闭包
    }

    private class Body{
        String content

        void hello(String s){
            println "BODY:${s}"
            content = s
        }
    }
}

@TypeChecked
def mail(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value=Email) Closure c){
    def email = new Email()
    //创造一个闭包的拷贝
    //入参分别是delegate owner thisObject
    def code = c.rehydrate(email, this, this)
    code.resolveStrategy = Closure.DELEGATE_ONLY //改变优先级
    code() //调用闭包
}


mail {
    from "yijun"
    to "wizard"
    subject "hello wizard!"
    body {
        hello "i'm yj"
    }
}