package com.doit.day02

object DemoMethod {
  def main(args: Array[String]): Unit = {
    val i = addInt(4, 2)
    println(i)
    val j = addParam(1, 2, 3, 4, 5)
    println(j)
    addDouble(1.5,0.4)
    subInt
  }

  //没参数
  def subInt: Unit ={
    println(3-1)
  }

  def addDouble(a:Double,b:Double): Unit ={
    println(a+b)
  }

  def addInt(x:Int,y:Int):Int={
    x+y
  }

  //可变参数
  def addParam(i:Int*):Int={
    var res = 0
    for (elem <- i) {
     res+= elem
    }
    res
  }

}
