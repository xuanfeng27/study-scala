package com.doit.day01

import scala.io.StdIn

object Demo05 {
  def main(args: Array[String]): Unit = {
    var b: Byte = 130.toByte
    println(b)

    /**
     *
     * 在 Scala 中其实是没有运算符的，所有运算符都是方法。
    1）当调用对象的方法时，点.可以省略

     */
    val i:Int = 1.+(1)
    println(i)

    //Scala 中 if else 表达式其实是有返回值的，具体返回值取决于满足条件的 代码体的最后一行内容。
    //Scala 中返回值类型不一致，取它们共同的祖先类型。
    println("input age")
    var age = StdIn.readInt()
    var res: Any = if(age >20 && age<30){
      "20-30"
    }else if(age<20){
      "<20"
    }else{

    }
    println(res)


    // 嵌套循环,等于双层for循环
    for (i<- 1 to 3;j<-1 to 3){
      println(s"$i---$j")
    }

    //当包含多个表达式时，一般每行一个表达式，并用花括号代替圆括号
    for {
      i<- 1 to 3
      j=4-i
      if j>2
    } {
      println(s"$i   $j")
    }


    var res2 = for(i <-1 to 10) yield {
      i * 2
    }
    println(res2)  //Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

  }
}
