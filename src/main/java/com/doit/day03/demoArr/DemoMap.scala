package com.doit.day03.demoArr

import scala.collection.mutable

object DemoMap {
  def main(args: Array[String]): Unit = {
    //不可变map
    val map1 = Map[String, Int]("aaa" -> 11, "bbb" -> 22, "ccc" -> 33)
    println(map1.keys.toList)
    val list = map1.values.toList
    val v1 = map1("aaa")
    for (elem <- map1) {
      val key = elem._1
      val value = elem._2
    }
    for ((k,v) <- map1) {
      println(k+"\t"+v)
    }

    for ((k,_) <- map1) {//只取key
      println(k)
    }

    map1.map(e=>println(e._2))//有返回值
    map1.foreach(e=>println(e._1))

    val map2 = Map[String, String](("a", "aa"), ("b", "bb"))

    val map3 = Map(("1", ("a", "aa")), ("2", ("b", "bb")))
    println(map3("1")._2)

    val map4 = Map[String, Teacher]("a" -> Teacher("zss", 11), "b" -> Teacher("lss", 23))
    println(map4("a"))


    //可变Map
    val map = mutable.Map((1, "a"), (2, "b"))
    map.put(3,"c")
    map.+=((4,"d"))
    println(map(1))
    val option: Option[String] = map.get(4)
    if(option.isDefined){
      println(option.get)
    }else{
      println("no")
    }
    map.remove(1)
    println(map.toList)


  }
}
