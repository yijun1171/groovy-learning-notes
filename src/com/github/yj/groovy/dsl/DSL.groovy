package com.github.yj.groovy.dsl

def show = { println it }
def square_root = { Math.sqrt(it) }

def please(action){
    [the:{what ->
        [of:{n -> action(what(n))}]
    }]
}

//要是以前没接触过 可能会被这多层闭包搞晕 :)
please show the square_root of 100

please(show).the(square_root).of(100)