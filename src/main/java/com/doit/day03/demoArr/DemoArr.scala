package com.doit.day03.demoArr

import scala.collection.mutable.ArrayBuffer

//数组默认不可变的集合,长度不可变，元素值可变
// update 共有的方法
object DemoArr {
  def main(args: Array[String]): Unit = {
    val arrStr: Array[String] = Array[String]("y", "b", "c")
    val sortedArr = arrStr.sorted
    for (elem <- sortedArr) {
      println(elem)
    }
    for (i<- 0 until arrStr.length){
      println(arrStr(i))
    }
    val array: Array[Unit] = arrStr.map(x => println(x))
    val unit: Unit = arrStr.foreach(x => println(x))//无返回值
    arrStr.update(0,"000")
    val array1: Array[String] = arrStr :+ "hhhhh"//

    //可变数组 insert(idx,e*)  insertAll(idx,Array)
    val buffer = ArrayBuffer[String]()
    buffer.append("ab")
    buffer.remove(0)
    buffer.clear()
    buffer+="333"//
    buffer++=(ArrayBuffer[String]("dao","mu"))//加buffer集合
    println(buffer.length)
    buffer.update(0,"aaa")
    buffer.foreach(e=>println(e))
    println(buffer.toList)
    buffer-="aaa"
    buffer--=(ArrayBuffer[String]("dao"))//
    println(buffer.toList)

  }

}
