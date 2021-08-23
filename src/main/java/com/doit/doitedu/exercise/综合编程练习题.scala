package com.doit.doitedu.exercise

import java.io.File
import java.util.UUID
import scala.collection.mutable.ListBuffer
import scala.io.{BufferedSource, Source}

object 综合编程练习题 {

  def main(args: Array[String]): Unit = {

    /**
     * 练习题1：如有如下数据：
     * 用户id,行为名称,时间戳
     * 1,A,13
     * 1,B,14
     * 1,C,15
     * 1,C,16
     * 1,A,18
     * 1,A,19
     * 1,C,22
     * 1,D,23
     * 1,A,33
     * 2,B,13
     * 2,A,14
     * 2,C,15
     * 2,A,16
     * 2,D,18
     * 2,E,19
     * 2,C,22
     * 2,D,23
     * 2,A,33
     *
     * （行为路径分析）
     * 计算出哪些人满足如下行为要求：
     * 做过A，后面做过任意2个不关心的行为，然后做了C,然后紧接着做了A，中间隔任意不关心的事件后，做过D  =>  .*?A\\w{2}CA.*?D.*?
     * 做过C，后面做过E，后面做过G  =>   .*?C.*?E.*?G.*?
     *
     * 1, ABCCAACDA
     * 2, BACADECDA
     *
     */
    val source: BufferedSource = Source.fromFile("data/events.txt")

    val lst: List[(String, String, String)] = source
      .getLines()
      .map(line => {
        val arr: Array[String] = line.split(",")
        (arr(0), arr(1), arr(2))
      }).toList
    println(lst)

    val mp: Map[String, List[(String, String, String)]] = lst.groupBy(tp => tp._1)
    println(mp)

    val mp2: Map[String, String] = mp.mapValues(lst => {
      lst.sortBy(tp => tp._3).map(tp => tp._2).mkString("")
    })
    println(mp2)

    val mp3: Map[String, Boolean] = mp2.mapValues(str => {
      str.matches(".*?A\\w{2}CA.*?D.*?")
    })
    println(mp3)


    source.close()

    /**
     * 练习题2：如有如下数据：
     * 用户id,行为名称,时间戳
     * "1,A,13"
     * "1,B,14"
     * "1,C,15"
     * "1,C,16"
     * "1,A,18"
     * "1,A,19"
     * "1,C,22"
     * "1,D,23"
     * "1,A,33"
     * "2,B,13"
     * "2,A,14"
     * "2,C,15"
     * "2,A,16"
     * "2,D,18"
     * "2,E,19"
     * "2,C,22"
     * "2,D,23"
     * "2,A,33"
     *
     * （漏斗模型）   ACCDEACDD
     * 公司的运营分析师，定义了一条业务路径：  A -> C -> D
     * 请计算，哪些人在这条业务路径上，以及进行到了第几步
     * u1,2
     * u2,3
     * u3,1
     */

    val s: BufferedSource = Source.fromFile("data/events.txt")
    val iter: Iterator[String] = s.getLines()
    val tmp1: List[Array[String]] = iter.map(s => s.split(",")).toList
    val tmp2: Map[String, List[Array[String]]] = tmp1.groupBy(arr => arr(0))
    val tmp3: Map[String, List[Array[String]]] = tmp2.mapValues(lst => lst.sortBy(arr => arr(2).toInt))
    val tmp4: Map[String, List[String]] = tmp3.mapValues(lst => lst.map(arr => arr(1)))

    // 1 -> AACDEDACCCAAAD
    // 2 -> BCAAAACCDACA
    val tmp5: Map[String, String] = tmp4.mapValues(lst => lst.mkString(""))
    val res = tmp5.mapValues(s => {
      s match {
        case s: String if s.matches(".*?D.*?E.*?A.*?") => 3
        case s: String if s.matches(".*?D.*?E.*?") => 2
        case s: String if s.matches(".*?D.*?") => 1
        case _ => 0
      }
    })
    println(res)
    s.close()

    /**
     * 练习题3：如有如下数据：
     * [用户id,行为名称,时间戳,会话id],要添加的字段（拆分后的会话Id)
     * 1,A,13,s01  ,ns01
     * 1,B,14,s01  ,ns01
     * 1,C,15,s01  ,ns01
     * 1,C,16,s01  ,ns01
     * 1,A,68,s01  ,ns02
     * 1,A,69,s01  ,ns02
     * 1,C,72,s01  ,ns02
     * 1,D,73,s01  ,ns02
     * 1,A,73,s01  ,ns02
     * 2,B,13,s02  ,ns03
     * 2,A,14,s02  ,ns03
     * 2,C,15,s02  ,ns03
     * 2,A,16,s02  ,ns03
     * 2,D,18,s02  ,ns03
     * 2,E,19,s02  ,ns03
     * 2,C,22,s02  ,ns03
     * 2,D,23,s02  ,ns03
     * 2,A,33,s02  ,ns03
     *
     * 由于咱们公司的app采用了会话保持技术，会让会话时长的计算变得不准确
     * 所以需要去对原始数据做一个会话分割
     *
     */

    println("===================  会话切割 ===============================")
    val source1: BufferedSource = Source.fromFile("data/b.txt")
    val lines: List[String] = source1.getLines().toList
    val grouped: Map[String, List[String]] = lines.groupBy(s => s.split(",")(3))
    val list: List[List[String]] = grouped.values.toList

    // 对每一个会话事件列表进行排序
    val tm1: List[List[String]] = list.map(lst => lst.sortBy(s => s.split(",")(2)))
    //
    val tm2 = tm1.map(lst => {
      var mySessionId: String = UUID.randomUUID().toString

      val resList = for (i <- 0 until lst.size) yield {

        // 先返回当前条+mysessionid
        val data = lst(i) + "," + mySessionId

        // 如果判断下一条的时间戳比当前条的时间戳超过30，则重新赋值mysessionid
        if (i != lst.size - 1) {
          val nextTimeStamp = lst(i + 1).split(",")(2).toInt
          val curTimeStamp = lst(i).split(",")(2).toInt
          if (nextTimeStamp - curTimeStamp > 30) {
            mySessionId = UUID.randomUUID().toString
          }
        }
        data
      }

      // 返回处理后的list
      resList
    })


    // 打散
    val result: List[String] = tm2.flatten
    result.foreach(println)


    source1.close()


    /**
     * 练习题4：如有如下数据：
     * 有如下数据：  用户：该用户的好友列表
     * A:B,C,D,F,E,O
     * B:A,C,E,K
     * C:F,A,D,I
     * D:A,E,F,L
     * E:B,C,D,M,L
     * F:A,B,C,D,E,O,M
     * G:A,C,D,E,F
     * H:A,C,D,E,O
     * I:A,O
     * J:B,O
     * K:A,C,D
     * L:D,E,F
     * M:E,F,G
     * O:A,H,I,J
     * 计算出，这些用户中，哪些用户两两之间有共同好友，以及这些共同的好友都是谁
     * A 和 B ：  C,E
     * A 和 C ：  D,F
     */


  }

}
