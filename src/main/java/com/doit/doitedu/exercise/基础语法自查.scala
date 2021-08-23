package com.doit.doitedu.exercise

object 基础语法自查 {

  def main(args: Array[String]): Unit = {


    // case class 的定义
    case class Event(eventId: String, timeStamp: Long) extends Ordered[Event] {
      override def compare(that: Event): Int = this.timeStamp.compareTo(that.timeStamp)
    }
    val e1: Event = Event("a", 1)
    val e2: Event = Event("b", 2)
    e1.compare(e2)

    // 各类集合的构造  List   Map   Array  Seq   Set
    List(1, 2, 3, 4)
    Map("a" -> 18, ("b", 28))

    // 集合上的常用api： map flatMap filter sort groupby  foreach  reduce   sum  max min maxBy  minBy    zip  zipWithIndex

    // ordering (Comparator)的构造    继承ordered (Comparable)
    val ord = new Ordering[Event] {
      override def compare(x: Event, y: Event): Int = x.timeStamp.compareTo(y.timeStamp)
    }
    ord.compare(e1, e2)


    // 会写匿名函数
    (a: Int, b: Int) => a * b
    val f = (a: Int, b:String) => {
        a + b.toInt
      }

      // 模式匹配
      e1 match {
        case Event("a", 13) => println("完全就是a,13")
        case e: Event => println(e)
        case Event(x, y) if y > 3 => println(x)
        case _ => println("其他")
      }

  }
}
