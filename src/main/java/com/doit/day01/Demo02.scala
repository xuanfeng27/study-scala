package com.doit.day01

import scala.util.Random

object Demo02 {
  def main(args: Array[String]): Unit = {
    var arr = Array[String]("a","b","c","d")
    println(arr(1))
    val random = new Random()
    val i = random.nextInt(arr.length)
    if (arr(i).equals("a")) {
      println("aa")
    }else if (arr(i).equals("b")){
      println("bb")
    }else if (arr(i).equals("c")){
      println("cc")
    }else{
      println("dd")
    }
  }
}
