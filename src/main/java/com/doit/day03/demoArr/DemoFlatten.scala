package com.doit.day03.demoArr

import scala.io.Source

//摊平集合中的子集合
object DemoFlatten {
  def main(args: Array[String]): Unit = {
    val array = Array(Array(1,2,3), Array(7,8,9))
    val res: Array[Int] = array.flatten
    val arr1 = Array("abc", "hello")
    val res1: Array[Char] = arr1.flatten
    res1.foreach(println)

    //flatten
    val res2 = Source.fromFile("D:\\word.txt")
      .getLines()
      .map(_.split("\\s"))
      .toList
      .flatten
      .foreach(println)

    //wordCount
    val res3 = Source.fromFile("D:\\word.txt")
      .getLines()
      .flatMap(_.split("\\s"))
      .map((_,1))
      .toList
      .groupBy(_._1)
      .map(tp=>{(tp._1,tp._2.length)})
      .toList
      .sortBy(- _._2)
      .foreach(println)



    val arr = Array(
      Person("aaa", 11, "abc"),
      Person("ooo", 44, "ss"),
      Person("ccc", 122, "ae"),
      Person("ooo", 34, "ss")
    )
    println(arr.max)
    println(arr.min)




  }
}
