package com.github.yj.groovy.mp

import java.lang.reflect.Method

//ExpandoMetaClass
//动态修改类方法 属性

class Book {
    String title

    def static sale(){
        "sale"
    }
}

//增加方法
Book.metaClass.titleToUpperCase = {-> title.toUpperCase()}
def book = new Book(title: "Gone with wind")
assert "GONE WITH WIND" == book.titleToUpperCase()

//增加属性
Book.metaClass.author = "Mike"
book = new Book(title: "Death note")
assert "Mike" == book.author

//static method
Book.metaClass.static.create = {String title -> new Book(title: title)}
Book sBook = Book.create("Clod")
assert sBook.title == "Clod"


//"函数指针"
class Shop {}
Shop.metaClass.sale = Book.&sale
shop = new Shop()
assert "sale" == shop.sale()


Method[] methods  = book.getClass().getMethods()
for (Method m : methods){
    println m.getName()
}

//像这样通过metaClass改动的方法和属性 不能通过反射获取
MetaMethod m = book.metaClass.getMetaMethod("titleToUpperCase")
println m.invoke(book)

