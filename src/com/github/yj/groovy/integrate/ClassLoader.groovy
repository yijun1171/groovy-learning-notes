package com.github.yj.groovy.integrate

/**
 * Created by yijun.yj on 2015/8/26.
 * classLoader方式加载
 */
def gcl = new GroovyClassLoader()
def clazz = gcl.parseClass("class Foo {void foo(){ println 'OK'}}")
assert clazz.name == "Foo"

def o = clazz.newInstance()
o.foo()

def clazz2 = gcl.parseClass("class Foo {void foo(){ println 'OK'}}")

//以字符串形式加载的class 每次都不一样
assert clazz.name == clazz2.name
assert clazz != clazz2

//以文件形式加载
def home = System.getProperty("user.dir")
def separator = System.getProperty("file.separator")
File file = new File(home+separator+"Shell.groovy")
clazz = gcl.parseClass(file)
clazz2 = gcl.parseClass(new File(file.absolutePath))
assert clazz == clazz2

//ps:为避免Class撑爆PermGen 每加载一个类 都要使用新的classLoader
//因为只有classLoader接触对所有它所加载的Class的引用 这些Class对象才能被GC

