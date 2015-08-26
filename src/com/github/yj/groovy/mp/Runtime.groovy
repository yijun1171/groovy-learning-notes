package com.github.yj.groovy.mp

//runtime meta-programming

/**
 * invokeMethod
 */
class GroovyClass {

    def test(){
        return "test method"
    }

    //一般方法调用失败时 会调用该方法 但不推荐使用
    def invokeMethod(String name, Object args){
        return "called invokeMethod $name $args"
    }
}

def groovyClass = new GroovyClass()
assert groovyClass.test("test") == "called invokeMethod test [test]"


/**
 * 属性访问拦截
 */
class PropertyInterception {

    def name
    def gender

    def getProperty(String name){
        if(name == "gender")//拦截属性访问
            return "male"
        else
            return metaClass.getProperty(this, name)
    }

    void setProperty(String name, Object value){
        if(name == "gender")
            this.@"$name" = 'male' //跟ruby太相似了
    }
}

def p = new PropertyInterception(name: "Tom", gender: "female")
assert p.name == "Tom"
assert p.gender == "male"
p.gender = "female"
assert p.gender == "male"

/**
 * methodMissing
 */
class MethodMissing{

    def defaultMethod() {
        return "default"
    }

    def methodMissing(String name, def arg){
        return "method missing"
    }

}

def mm = new MethodMissing()
assert mm.defaultMethod() == "default"
assert mm.testMethodMissing() == "method missing"


//def nCopy = {int times, String s -> s*times}
//
//class GORM {
//
//    def dynamicMethods = [] // an array of dynamic methods that use regex
//
//    def methodMissing(String name, args) {
//        def method = dynamicMethods.find {it.match(name)}
//        if(method) {
//            GORM.metaClass."$name" = { Object[] varArgs ->
//                method.invoke(delegate, name, varArgs)
//            }
//            return method.invoke(delegate,name, args)
//        }
//        else throw new MissingMethodException(name, delegate, args)
//    }
//}
//def g = new GORM()
////g.dynamicMethods.add(nCopy)
//g.nCopy(2,"hello")