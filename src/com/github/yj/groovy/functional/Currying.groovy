package com.github.yj.groovy.functional


//left currying
def nCopys = {int times, String s -> s*times }
def twice = nCopys.curry(2)
assert twice("ha") == 'haha'

//right currying
def ha = nCopys.rcurry("ha")
assert ha(3) == 'hahaha'




