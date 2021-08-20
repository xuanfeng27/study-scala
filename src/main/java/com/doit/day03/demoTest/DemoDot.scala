package com.doit.day03.demoTest

object DemoDot {
  def main(args: Array[String]): Unit = {
    //:: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为x::list,
    // 其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，
    // 也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
    val list = List("a", "b", "c")
    println("aa" :: list)

    /**
     * :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，
     * 但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了，
     * 加号位置决定元素(无论元素还是集合)加在前还是后。
     */
    println(list :+ "tail")
    println(list +: "head")
    println("head" +: list)// :需要靠近集合类型

    val list2 = List("2", "1", "3")
    println(list :+ list2)//加入集合也只被当做是原集合的一个元素

    //++ 该方法用于连接两个集合(列表，数组等)，list1++list2
    println(list ++ list2)
    //::: 该方法只能用于连接两个List类型的集合
    println(list ::: list2)

    val ls = List(("a", 1), ("b", 2), ("c", 3))
    for ((word,count) <- ls) {
      println(word+" "+count)
    }


  }
}
