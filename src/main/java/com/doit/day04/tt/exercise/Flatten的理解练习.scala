package com.doit.day04.tt.exercise



object Flatten的理解练习 {

  def main(args: Array[String]): Unit = {
    val lst = List(List(1, 2, 3), List(4, 4, 5))
    // 给我压平上面的lst  [1,2,3,4,4,5]
    println(lst.flatten.toArray.mkString("[", ", ", "]"))


    val lst2 = List(Map("a" -> 1, "b" -> 2), Map("c" -> 3, "a" -> 4))
    // 给我压平上面的lst  [("a",1),("b",2),("c",3),("a",4)]
    println(lst2.flatten.mkString("[", ", ", "]"))


    val mp = Map("a" -> 1, "b" -> 2, "c" -> 3)
    // 给我压平 ["a",1,"b",2,"c",3]
    println(mp.map(t => t.productIterator).flatten.toList)







  }
}
