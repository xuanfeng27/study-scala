package com.doit.day05


/**
 * 泛型的应用案例3
 * 　　*　－要求
 * 　　*　　　1) 定义一个函数，可以获取各种类型的List的所有奇数索引上的值的List
 * 　　*　　　2) 使用泛型完成
 */
object DemoFanXing {

  def main(args: Array[String]): Unit = {

    def getOddNum[T](lst:List[T]):List[T]={
     lst.zipWithIndex.filter(_._2%2==1).map(_._1)
    }
    println(getOddNum(List[Int](1, 2, 3, 4, 5)))
    println(getOddNum(List[String]("a", "b", "c", "d")))
  }
}
