package com.github.yj.groovy.mp.module

//模块扩展
class MaxRetriesExtension {

    static void maxReries(Integer i, Closure c){
        int retries = 0
        Throwable e
        while (retries < i){
            try{
                c()
                break
            } catch (Throwable t){
                e = t
                retries++
            }
        }

        if(retries != 0 && e){
            throw e
        }
    }
}
