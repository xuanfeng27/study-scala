package com.doit.day03.demoTest
import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

object DemoParallel {
  def main(args: Array[String]): Unit = {
    val res: immutable.IndexedSeq[String] = (1 to 100).map(num => Thread.currentThread().getName)
    println(res)

    val res2: ParSeq[String] = (1 to 100).par.map(num => Thread.currentThread().getName)
    println(res2)
  }
}
