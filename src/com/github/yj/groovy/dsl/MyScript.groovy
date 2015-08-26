package com.github.yj.groovy.dsl

import groovy.transform.BaseScript

//指定当前脚本的基类
@BaseScript
MyBaseScript script

setName("script")
println "hello"
