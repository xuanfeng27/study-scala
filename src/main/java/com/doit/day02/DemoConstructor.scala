package com.doit.day02

import scala.beans.BeanProperty

class DemoConstructor(val name:String,val age:Int){
  private var bb:Int=123

  @BeanProperty
  var mb:Int=3

  var addr:String = _
  def this(name:String,age:Int,addr:String) ={
    this(name,age)
    this.addr = addr
  }

}

object DemoConstructor {

  def apply(name: String, age: Int): DemoConstructor = new DemoConstructor(name, age)

  def main(args: Array[String]): Unit = {
    val demo1 = new DemoConstructor("aaa",11)
    println(demo1.name)//成员变量

    val demo2 = new DemoConstructor("ccc", 33, "ss")
    println(demo2.addr)

    val demo3 = DemoConstructor("bbb", 22)
    println(demo3.name)

    println(demo1.bb)

    demo1.setMb(555)
    println(demo1.getMb)


    val demoPrivate = new DemoPrivate
    println(demoPrivate.b)
    println(demoPrivate.c)
  }

}
