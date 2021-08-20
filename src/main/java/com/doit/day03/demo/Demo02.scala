package com.doit.day03.demo


object Demo02 {
  def main(args: Array[String]): Unit = {
    println(test1(1, 2))
    println(test2(1, 3))
  }

  val test1: (Int, Int) => Int = (x, y) => {
    x * y
  }
  def test2: (Int, Int) => Int = (x, y) => {
    x * y
  }

}


