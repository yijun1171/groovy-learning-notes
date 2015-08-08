package com.github.yj.groovy.functional

class This{ //this 关键字测试
    void run(){
        def thisObject = {getThisObject()} //获取的是当前对象
        assert this == thisObject()
        this.getName()
    }

    String getName(){"this"}
}

def thisTest = new This()
thisTest.run()


class Owner{ //测试owner
    void run(){
        def ownerObject = {getOwner()}
        def whatIsOwner = {owner}

        assert ownerObject() == this
        assert whatIsOwner() == this
        def closure = {
            def innerClosure = { owner }//这里返回closure对象
            assert this != innerClosure()
        }

        closure()
    }

}
def ownerTest = new Owner()
ownerTest.run()



class Person{
    String name;
    def pretty = { "My name is $name"}
    String toString(){
        pretty()
    }

}

class Thing{
    String name
}

def p = new Person(name: "Tom")
def t = new Thing(name: "Teapot")

assert p.toString().equals('My name is Tom')
p.pretty.delegate = t
assert p.toString() == 'My name is Tom'

p.pretty.resolveStrategy = groovy.lang.Closure.DELEGATE_FIRST //改变解析策略
assert p.toString() == 'My name is Teapot'


def x = 1
def gs = "x = $x"//在此处已经被求值了
assert gs == 'x = 1'

x = 2
assert gs != 'x = 2'//gs仍指向之前那个对象

def gcs = "x = ${->x}" //形成一个闭包
assert gcs == 'x = 2'
x = 3
assert gcs == 'x = 3'

