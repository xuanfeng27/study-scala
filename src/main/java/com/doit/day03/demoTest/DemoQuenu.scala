package com.doit.day03.demoTest

import scala.collection.mutable

object DemoQuenu {
  def main(args: Array[String]): Unit = {
    val queue = mutable.Queue[String]()
    queue.enqueue("a","b","c")
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue)
  }
}
