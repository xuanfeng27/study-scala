package com.doit.day02.demoTrait
//样例类
//1 主构造器中的属性默认就是成员属性  不需要使用 val  var修饰
// * 2 重写了toString

case class DemoCase(name:String,age:Int)

object DemoCase{
  //可以省略
/*  def apply(name: String, age: Int): DemoCase = new DemoCase(name, age)

  def unapply(demo1: DemoCase): Option[(String, Int)] = {
    if (demo1==null)
      None
    else
      Some(demo1.name,demo1.age)
  }*/

  def main(args: Array[String]): Unit = {
    val demo1 = DemoCase("zss",11)
    println(demo1)

    val result = demo1 match {//Scala 中的模式匹配类似于 Java 中的 switch 语法
      case DemoCase("zss", 11) => "yes"
      case _ => "no"
    }
    println(result)

    //模式匹配
    val (x, y) = (1, 2)
    println(s"x=$x,y=$y")


    //表达式中的模式匹配
    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for ((k, v) <- map) { //直接将 map 中的 k-v 遍历出来
      println(k + " -> " + v) //3 个
    }
    println("----------------------")
    //遍历 value=0 的 k-v ,如果 v 不是 0,过滤
    for ((k, 0) <- map) {
      println(k + " --> " + 0) // B->0
    }
    println("----------------------")
    //if v == 0 是一个过滤的条件
    for ((k, v) <- map if v >= 1) {
      println(k + " ---> " + v) // A->1 和 c->33
    }


  }

}
