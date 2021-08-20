package com.doit.day02

object DemoFunction {

  val addFun1: (Int, Int) => Int = (x, y) => {
    x + y
  }

  val addFun2=(x:Int,y:Int)=>x+y


  val test: (Int, Int) => Int = (a, b) => a * b*10

  def add(x:Int,y:Int,f:(Int,Int)=>Int): Int ={
    f(x,y)
  }


  def main(args: Array[String]): Unit = {
    println(addFun1(2, 3))
    println(addFun2(1, 2))

    val res: Int = add(20, 2, (x, y) => {
      x * y
    })
    println(res)

    println(add(3, 3, test))
  }
}
