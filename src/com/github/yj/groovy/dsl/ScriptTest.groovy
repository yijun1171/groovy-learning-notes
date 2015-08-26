package com.github.yj.groovy.dsl

import org.codehaus.groovy.control.CompilerConfiguration

def config = new CompilerConfiguration()
config.scriptBaseClass = "MyBaseScript"

def shell = new GroovyShell(this.class.classLoader, config)
def result = shell.evaluate """
    setName "Mike"
    greet()
"""
assert 1 == result

def script = shell.parse("println 'OK'")
assert 1 == script.run()
assert 2 == script.run()

def home = System.getProperty("user.dir")
def separator = System.getProperty("file.separator")
def myScript = shell.parse(new File(home+separator+"MyScript.groovy"))
assert 1 == myScript.run()