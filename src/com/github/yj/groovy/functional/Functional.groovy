package com.github.yj.groovy.functional

def list = [1,2,3]
list.each {println it}

def func = {item -> println item}
func("hello")

func = {println it}
func("world","yijun")