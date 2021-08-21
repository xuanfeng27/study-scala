package com.doit.day05.tt.doitedu.review

object ReviewDay04 {

  def main(args: Array[String]): Unit = {

    // List 中添加元素的几个操作符（方法）：    :+  +:  ::  :::
    5 +: Nil
    Nil :+ 5
    6 :: 5 :: Nil
    val lst = List(4, 8) ::: List(5, 6, 7)
    println(lst)


    /**
     * 高阶函数 ( 参数或者返回值又是函数）
     */
    lst.map(x => x + 10) // map就是一个高阶函数

    // 以函数作为参数
    def highLevelFunc(x: Int, f: Int => String): Unit = {
      f(x) + 10
    }

    highLevelFunc(10, x => (x + 10) + "")

    // 以函数作为返回值
    def highLevelFunc2(x: Int): Int => Int = {
      val f = (y: Int) => {
        x + y
      }
      f
    }

    // (y:Int) => {10 + y}
    val retFunc = highLevelFunc2(10)
    retFunc(20) // 30


    /**
     * 隐式转换
     */
    // 隐式参数（值）
    implicit val s: String = "zhangsan"

    // 隐式方法
    implicit def sToInt(str: String) = str.toInt

    // 隐式类
    implicit class MyInt(n:Int){
      def intSayHello(): Unit ={
        println(s"hello $n")
      }
    }
    val n = 10
    n.intSayHello()

  }
}
