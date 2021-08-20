package com.doit.day03.demoArr

import scala.collection.mutable

object DemoSet {
  def main(args: Array[String]): Unit = {
    val set = Set(2, 3, 1, 3, 4, 2, 5)
    set.foreach(e=>println(e))
    set.foreach(println)

    val set1 = mutable.HashSet[Int]()
    set1.add(3)
    println(set1)


    val list = List[Int](2, 4, 5, 1, 6, 8, 0)
    val tuples = list.map(e => (e, 1))//list.map((_, 1))
    println(tuples)

    val array = Array[String]("hello","java","c","js")
    val tuples1 = array.map(e => (e, 1))

  }
}
