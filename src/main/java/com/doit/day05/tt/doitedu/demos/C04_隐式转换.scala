package com.doit.day05.tt.doitedu.demos

object C04_隐式转换 {

  def main(args: Array[String]): Unit = {

    println("==============隐式变量 =====================")
    // 1. 隐式变量
    implicit val nickname:String = "张三丰"
    // implicit val nickname:String = "张三丰"  // 如果有两个同类型的隐式变量，则下面的隐式参数将无法正确传递

    // 1. 隐式参数
    def sayHello(implicit name:String): Unit ={
      println(s"hello $name")
    }

    sayHello

    println("============== 隐式方法 =====================")

    // 2. 隐式方法
    implicit def intToMyInt(n:Int) = new MyInt(n)
    val n: Int = 5
    // 在Int类型的对象上调用 factorial 方法，显然编译是通不过的
    // 那么scala的编译器还会设法挽救： 去上下文中寻找一个 隐式方法，看这个方法是否能把Int转成一个别的类型并且拥有factorial方法
    // 如果找到了，编译器就帮你把代码悄悄地改成了： (intToMyInt(n)).factorial
    val res = n.factorial
    println(res)


    println("============== 隐式类 =====================")
    // 2. 隐式类
    implicit class HelloInt(x:Int){
      def sayHello(): Unit ={
        println(s"hello ${x}")
      }
    }

    val x = 10
    // x.sayHello  ====>   (new HelloInt(x)).sayHello
    x.sayHello

  }
}

class MyInt(val n:Int){
  def factorial:Int = {
    var res = 1
    for(i <- 1 to n ) res =  res*i
    res
  }
}

