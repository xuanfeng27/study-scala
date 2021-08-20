package com.doit.day03.demoArr

import scala.io.Source

object DemoWordCnt {
  def main(args: Array[String]): Unit = {

    Source.fromFile("d://word.txt")
      .getLines()
      .flatMap(str=>{str.split("\\s")})
      .toList
      .groupBy(word=>word)
      .map(tp=>{(tp._1,tp._2.length)})
      .toArray
      .sortBy(- _._2)
      .take(3)
      .foreach(println)

    wordCount()
  }

  def wordCount():Unit={

    val list= List[(String,Int)](
      ("hello",1),
      ("hello world",2),
      ("hello scala",3),
      ("hello scala spark",4)
    )

    //不推荐使用
    println(list
      .map(tp=>{(tp._1+" ")*tp._2})
      .flatMap(_.split("\\s"))
      .groupBy(word=>word)
      .mapValues(_.length)
      .toList
      .sortBy(- _._2)
    )

    //推荐
    val listResult = list.flatMap(tp=>{
     tp._1
       .split("\\s")
       .map((_,tp._2))
    })
      .groupBy(_._1)
      .mapValues(_.map(_._2).sum)
      .toList
      .sortBy(- _._2)
      .take(3)
      .foreach(print)
  }
}
