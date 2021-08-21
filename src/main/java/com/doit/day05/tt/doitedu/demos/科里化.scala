package com.doit.day05.tt.doitedu.demos

object 科里化 {
  def main(args: Array[String]): Unit = {

    // 1.有利于参数的类型推断
    // 写一个函数，接收一个list，根据判断逻辑找元素
    def findElement1[T](lst:List[T],f:T=>Boolean): Option[T] ={
      lst match {
        case Nil => None
        case head :: tail =>if(f(head)) Some(head) else findElement1(tail,f)
      }
    }

    println(findElement1(List(1, 3, 5, 9), (e: Int) =>  e > 4))
    // findElement(List(1,3,5,9),(e)=>{e > 8}) 报错，虽然参数1已经定了T为Int类型，但是无法推断下一个参数上的T

    // 科里化写法
    def findElement2[T](lst:List[T])(f:T=>Boolean): Option[T] ={
      lst match {
        case Nil => None
        case head :: tail =>if(f(head)) Some(head) else findElement2(tail)(f)
      }
    }
    findElement2 (List(1,3,5,9))(e=>e>8)


    // 2.有利于减少参数
    def addSalary(inc:Int,salary:Int) = inc+salary
    // 瑞瑞涨工资
    addSalary(200,18000)

    // 彩月涨工资
    addSalary(200,20000)


    def addSalary2(inc:Int)(salary:Int) = inc+salary

    val add200: Int => Int = addSalary2(200)  // y = 200+salary
    add200(18000)
    add200(20000)




  }
}
