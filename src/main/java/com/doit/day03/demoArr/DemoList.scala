package com.doit.day03.demoArr

import java.io
import scala.collection.mutable.ListBuffer

object DemoList {
  def main(args: Array[String]): Unit = {
    //不可变List
    val list = List[String]("a", "bb", "c")
    val list1 = list :+ list
    println(list1)
    val list2 = list.::("aaa","xxx")
    println(list2)
    val list3 = 11 :: 22 :: 33 :: 44 :: Nil
    println(list3)

    //可变list
    val listBuffer = ListBuffer[String]()
    listBuffer.append("aa")
    listBuffer+="bb"
    listBuffer.insert(0,"1","2")
    listBuffer.insertAll(0,List("li","ttt"))
    println(listBuffer)


  }
}
