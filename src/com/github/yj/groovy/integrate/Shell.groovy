package com.github.yj.groovy.integrate

/**
 * Created by yijun.yj on 2015/8/26.
 * GroovyShell方式
 */
def shell = new GroovyShell()

//evaluate直接返回脚本结果
def result = shell.evaluate("3*3")

//parse返回脚本对象
def script = shell.parse("3*3")
def result2 = script.run()

assert result == result2


