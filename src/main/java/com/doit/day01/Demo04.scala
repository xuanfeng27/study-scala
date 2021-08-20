package com.doit.day01

object Demo04 {
  def main(args: Array[String]): Unit = {
    var arr = Array[Int](1,2,3,4,5,6,7,8)
    val arr2: Array[Int] = for (elem <- arr if elem >4) yield {
      elem * 10
    }


  }
}
