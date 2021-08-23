package com.doit.day05

import java.io.File
import scala.io.Source

object DemoTest {
  def main(args: Array[String]): Unit = {

   // println(("a", 1).swap) 元组交换位置

   val list = List(1,2,3,4,"a")

   //1.定义一个偏函数
   def myParFun: PartialFunction[Any, Int] = {
     case x: Int => x * x
   }
    list.collect(myParFun).foreach(println)

    //2.偏函数简写
    list.collect({
      case i: Int => i * 10
    }).foreach(println)

    //1	平均温度案例
    val d1 = Array(("beijing", 28.1), ("shanghai", 28.7), ("guangzhou", 32.0), ("shenzhen", 33.1))
    val d2 = Array(("beijing", 27.3), ("shanghai", 30.1), ("guangzhou", 33.3))
    val d3 = Array(("beijing", 28.2), ("shanghai", 29.1), ("guangzhou", 32.0), ("shenzhen", 32.1))

    val data: Array[(String, Double)] = d1 ++ d2 ++ d3
    data.groupBy(tp => tp._1)
      .mapValues(arr => arr.map(_._2).sum/arr.length )
      .toList.foreach(println)
    println("------------------------------------------------------------")
    data.groupBy(tp => tp._1)
      .mapValues(arr=>{
      val d = arr.reduce((x, y)=>("",x._2+y._2))
      d._2/arr.length
    }).foreach(println)

    println("----------------------------2--------------------------------")
    /*2.获取任意两个人的共同好友
    A:B,C,D,F,E,O
    B:A,C,E,K
    C:F,A,D,I
    D:A,E,F,L
    E:B,C,D,M,L
    F:A,B,C,D,E,O,M
    G:A,C,D,E,F
    H:A,C,D,E,O
    I:A,O
    J:B,O
    K:A,C,D
    L:D,E,F
    M:E,F,G
    O:A,H,I,J*/

    val t: Iterator[(String, Array[String])] = Source.fromFile(new File("D:\\friends.txt"))
      .getLines()
      .map(line => line.split(":"))
      .map(arr => (arr(0), arr(1).split(",")))
      val arr = t.toArray
      val res = for(i<- 0 until arr.length-1; j<- i+1 until  arr.length) yield {
        val same: Array[String] = arr(i)._2.intersect(arr(j)._2)
        (arr(i)._1 + "和" + arr(j)._1 +"共同好友:" ,same)
      }

      res
        .map(tp=>(tp._1,tp._2.toList))
        .filter(tp=>tp._2.nonEmpty)
        .foreach(println)














    val ls = List("a","b","c")
    println(ls:+"s")
    println(ls)
  }
}
