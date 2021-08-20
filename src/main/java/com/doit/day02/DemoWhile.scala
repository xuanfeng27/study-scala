package com.doit.day02

import scala.util.control.Breaks.{break, breakable}

//scala 么有++ --
//与 for 语句不同，while 语句没有返回值，即整个 while 语句的结果是 Unit 类型()
object DemoWhile {
  def main(args: Array[String]): Unit = {
      var i = 10;
      while (i>6){
        println(s"$i")
        i-=1
      }

      breakable {
        for (elem <- 1 to 10) {
          println(elem)
          if (elem == 5) break
        }
      }
      println("正常结束循环")

  }



}
