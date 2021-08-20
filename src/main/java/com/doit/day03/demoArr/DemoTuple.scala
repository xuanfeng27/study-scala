package com.doit.day03.demoArr

//1,zss,23,M,coder
//1. JavaBean
//2. case class
//3. 元组
object DemoTuple {
  def main(args: Array[String]): Unit = {
    //元组定义
    val tp1 = (1, "zss", 23, "M", "coder")
    val id = tp1._1

    val iterator = tp1.productIterator
    while (iterator.hasNext){
      println(iterator.next())
    }

    val tup2 = new Tuple3[Int, String, Int](1, "zss", 23)
    println(tup2._1)

    //元组嵌套
    val tp3 = ((1, "zss", 23, "M", "coder"), (2, "lss", 13))
    println(tp3._1._1)

    //对偶元组
    val tp01 = ("a",3)
    val tp02 =("bbb","ccc")

    val str = (tp01._1+" ")* tp01._2
    println(str)//a a a

    println(tp02.toString().toList.mkString("-"))



  }
}
