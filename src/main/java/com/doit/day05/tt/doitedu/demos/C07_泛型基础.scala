package com.doit.day05.tt.doitedu.demos

object C07_泛型基础 {

  def main(args: Array[String]): Unit = {


    /*
     * 　基本介绍
     * 　　*     1) 如果我们要求函数的参数可以接受任意类型，可以使用泛型，这个类型可以代表任意的数据类型
     * 　　*     2) 例如List，在创建List时，可以传入整型、字符串、浮点数等等任意类型。那是因为List在类定义时引用了泛型。
     * 比如在Java中：public interface List<E> extends Collection<E>
     /


     */
     /*
     *   1.泛型方法示例
     */

    //类型定死的方法
    def max1(a: Int, b: Int): Int = a
    println(max1(1, 10))
    // max1("a","z")   这个不能调，因为方法的参数类型已经定死成了：Int

    // 使用了泛型的方法
    def max2[C](a: C, b: C): C = a
    println(max2[Int](1, 10))
    println(max2[String]("a", "c"))
    println(max2[Float](3.0f, 8.8f))


    /*
     *  2. 泛型类示例
     * 　_要求
     * 　　　1) 编写一个Message类
     * 　　　2) 可以构建Int类型的Message，String类型的Message
     * 　　　3) 要求使用泛型来完成设计(说明：不能使用Any)
     */
    // 类型定死的容器类
    class Message1(val content: String)
    new Message1("110")
    // new Message1(110)  传入非String类型的数据都会报错

    // 使用了泛型的容器类
    class Message2[T](val content: T)
    new Message2[String]("110")
    new Message2[Int](110)


    /**
     * 泛型的练习1
     * 　　_要求
     * 　　　1) 定义一个函数，可以获取各种类型的List的中间位置的值
     * 　　　2) 使用泛型完成
     */
    def findMidElement[T](lst: List[T]): T = {
      lst(lst.size / 2)
    }
    findMidElement[Int](List(1, 2, 3))
    findMidElement[String](List("a", "b", "c"))


    /**
     * 泛型的练习2
     * 　　_要求
     * 　　　1) 定义一个函数，可以获取各种类型的List的所有奇数索引上的值的List
     * 　　　2) 使用泛型完成
     */
    def oddIndexElements[T](lst:List[T]):List[T] = {

      (for(i <- lst.indices if i%2==1) yield lst(i)).toList

    }
    println(oddIndexElements[Int](List(1, 2, 3, 5, 9)))
    println(oddIndexElements[String](List("a","b","c","d")))


  }
}
