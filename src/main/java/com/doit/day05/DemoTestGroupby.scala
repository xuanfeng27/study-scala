package com.doit.day05

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object DemoTestGroupby {
  def main(args: Array[String]): Unit = {
    val listBf = ListBuffer[(String, String)]()
    listBf.append(("1","a"))
    listBf.append(("2","b"))
    println(listBf)

    val list = List(
      (1,"a","male",98.8,"spark"),
      (1,"a","male",68.8,"hadoop"),
      (3,"c","male",98.8,"hadoop"),
      (2,"b","female",88.8,"spark"),
      (2,"b","female",68.8,"hadoop"),
      (2,"b","female",98.8,"flink"),
      (3,"c","male",88.8,"spark"),
      (1,"a","male",48.8,"flink")
    )

    val map1 = list.groupBy(tp => tp._1 > 25)
    list.groupBy(_._3)
    list.groupBy(_._2.hashCode%3)
    list.groupBy(tp=>{
      tp._4 match {
        case score:Double if score <60 => "及格"
        case score:Double if score >60 & score <80 => "一般"
        case score:Double if score >80 => "优秀"
      }
    })

    list.groupBy(tp=>tp._2+tp._5)

    val lst2 = List(("a"->1),("c"->2),("d"->2),("e"->2),("f"->2),("g"->2))
    val m = new  mutable.HashMap[String, Int]()
    val res = lst2.foldLeft(m)((x,y)=>{
      x.put(y._1, y._2)
      x
    })
    val res2 = lst2.foldLeft(Map.empty[String,Int])((x, y)=> x.+(y))
    println(res2)

//
val lst3 = List(
  ("湖北省","张三丰",98),
  ("湖北省","郭靖",96),
  ("湖北省","小龙女",88),
  ("山东省","张三",98),
  ("山东省","张丰",98),
  ("山东省","三丰",99),
  ("河北省","张三丰",96),
  ("河北省","张无忌",92)
)

val  result: Map[String, Map[String, Int]] = lst3
  .groupBy(_._1)
  .mapValues(lst=> lst
    .map(tp=>(tp._2,tp._3))
    .toMap
  )
  println(result)










  }
}
