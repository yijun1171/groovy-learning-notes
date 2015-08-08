package com.github.yj.groovy.type

def var = 1
assert var == 1

var = "string"
assert var.equals("string")

List list = [0,1,2]
list = "hello"
println list