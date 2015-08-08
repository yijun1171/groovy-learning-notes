package com.github.yj.groovy.literal

def list = [1,2,3]
assert list.class.getName().equals("java.util.ArrayList")

def map = [name:"mike", gender:"male"]
assert map.getClass().getName() == "java.util.LinkedHashMap"
