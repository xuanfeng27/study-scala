package com.doit.day05.tt.doitedu.exercise

import scala.collection.immutable

object Flatten的理解练习 {

  def main(args: Array[String]): Unit = {
    val lst: List[List[Int]] = List( List(1, 2, 3), List(4, 4, 5))
    // 给我压平上面的lst  [1,2,3,4,4,5]
    val flatten: List[Int] = lst.flatten


    val lst2 = List( Map("a" -> 1, "b" -> 2), Map("c" -> 3, "a" -> 4) )
    // 给我压平上面的lst  [("a",1),("b",2),("c",3),("a",4)]
    val flatten1: List[(String, Int)] = lst2.flatten

    val mp = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val lst3: List[Product] = List((1,2,3,4,5,6,68,87),(2,6,6,7,8,4,22,1,3,7,9,90,1,1,1,2))
    // 给我压平 ["a",1,"b",2,"c",3]
    lst3.map(tp=>tp.productIterator).flatten

    // 利用productIterator 迭代器来遍历访问元组中的每一个元素
    val tp = (1,2,3,4,5,6,68,87)
    for (elem <- tp.productIterator) {
      println(elem)
    }


  }
}
