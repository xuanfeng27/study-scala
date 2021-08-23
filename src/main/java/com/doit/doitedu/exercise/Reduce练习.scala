package com.doit.doitedu.exercise

object Reduce练习 {
  def main(args: Array[String]): Unit = {

    val lst = List(1,2,5,4,5)
    lst.sum

    // 用reduce
    // 第1次调用：  (1,2)=> 3
    // 第2次调用：  (3,5)=> 8
    // 第3次调用：  (8,4)=> 12
    // 第4次调用：  (12,5)=> 17
    val res1: Int = lst.reduceLeft((b, i)=>{b+i} )

    val res2: Int = lst.reduceLeft((b, i)=>{b-i} )
    println(res2)  // -15

    // reduce无法返回跟原来数据不同类型的聚合值
    // val res3: String = lst.reduceLeft((b, i)=>{ b.toString + "," + i.toString } )

    // 第1次调用：  ("",1)=> ",1"
    // 第2次调用：  (",1",2)=> ",1,2"
    // 第3次调用：  (",1,2",5)=> ",1,2,5"
    // 第4次调用：  (",1,2,5",4)=> ",1,2,5,4"
    // 第5次调用：  (",1,2,5,4",5)=> ",1,2,5,4,5"
    val res3 = lst.foldLeft("")((b,i)=> b+","+i)
    println(res3)

    val res4 = lst.foldLeft("")((b,i)=> i+","+b)
    println(res4)

    // 根据如下list，得出一个Map ：  { String->Int }
    val lst2 = List(("a"->1),("c"->2),("d"->2),("e"->2),("f"->2),("g"->2))

    // 第1次调用：             {}  |  "a"->1 =>{"a"->1}
    // 第2次调用：       {"a"->1}  |  "c"->2 => {"a"->1,"c"->2}
    // 第3次调用：{"a"->1,"c"->2}  |  "d"->2 => {"a"->1,"c"->2 ,"d"->2 }
    lst2.foldLeft(Map.empty[String,Int])( (mp,tp)=>{ mp + tp  })


    // 根据如下list，得出一个双层Map ：  { 省份 -> {姓名，颜值 } }
    // 湖北省 -> {
    //             张三丰->98,
    //             郭靖->96,
    //             小龙女->88
    //          }
    // 山东省 -> {
    //             张少侠->68,
    //             关羽->99,
    //             赵云->99
    //          }
    val lst3 = List(
      ("湖北省","张三丰",98),
      ("湖北省","郭靖",96),
      ("湖北省","小龙女",88),
      ("山东省","张少侠",68),
      ("山东省","关羽",99),
      ("山东省","赵云",99),
      ("河北省","赵飞燕",96),
      ("河北省","张无忌",92)
    )

    val tmp1: Map[String, List[(String, String, Int)]] = lst3.groupBy(tp=>tp._1)
    tmp1.mapValues(lst=>lst.map(tp=>(tp._2,tp._3)).toMap)


    //  wordcount
    val lst4 = List("a b c d a e f g", "a b c d f d", "c d e f a j j h a")

    // List(Array("a","b","c","d","a"),Array())
    // List("a","b","c","d","a",.....)
    val tmp2: List[String] = lst4.flatMap(str =>str.split("\\s+"))
    val tmp3: Map[String, List[String]] = tmp2.groupBy(s=>s)
    val tmp4: Map[String, Int] = tmp3.mapValues(lst=>lst.size)



  }

}
