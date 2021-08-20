package com.doit.day02

class DemoPrivate {
  var b:Int=22
  private var a:Int=11
  private[day02] var c:Int=33

}

object DemoPrivate{
  def apply(): DemoPrivate = new DemoPrivate()

  def main(args: Array[String]): Unit = {
    val demo1 = DemoPrivate()
    println(demo1.a)
    println(demo1.b)
    println(demo1.c)
  }
}