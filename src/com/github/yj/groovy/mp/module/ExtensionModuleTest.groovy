package com.github.yj.groovy.mp.module

//模块扩展测试
//模块机制对类和对象的扩展是全局性的
int i = 0

5.maxReries {
    i++
}
assert i == 1

i=0
try{
    5.maxReries {
        i++
        throw new RuntimeException("oops")
    }
} catch (Throwable t){
    assert i == 5
}

assert "hello miles" == Integer.greeting("miles")