package com.doit.day01

import com.doit.day02.DemoPrivate


object Demo01 {
  def main(args: Array[String]): Unit = {
    println("hello")
    println(
      """
        |我是说
        |你在哪
        |哈哈哈
        |""".stripMargin)

    val name = "aaa"
    val gender = "男"
    var age = 23
    age=32;
    println(name+"-"+gender+"-"+age)
    println(s"$name-$gender-$age")

  }


}
