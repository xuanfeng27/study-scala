package com.doit.day05.tt.doitedu.exercise

import java.io
import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.{BufferedSource, Source}

object scala大总结 {

  def main(args: Array[String]): Unit = {

    // case class 的定义


    // 各类集合的构造  List   Map   Array  Seq   Set



    // 集合上的常用api： map flatMap filter sort groupby  foreach  reduce
    // sum  max min maxBy minBy zip  zipWithIndex


    // ordering 的构造    继承ordered



    // 会写匿名函数


    // 模式匹配


    /**
     * 练习题1：如有如下数据：
     *  用户id,行为名称,时间戳
     *   1,      A,       13
     *   1,      B,       14
     *   1,      C,       15
     *   1,      C,       16
     *   1,      A,       18
     *   1,      A,       19
     *   1,      C,       22
     *   1,      D,       23
     *   1,      A,       33
     *   2,      B,       13
     *   2,      A,       14
     *   2,      C,       15
     *   2,      A,       16
     *   2,      D,       18
     *   2,      E,       19
     *   2,      C,       22
     *   2,      D,       23
     *   2,      A,       33
     *
     *  （行为路径分析）
     *  计算出哪些人满足如下行为要求：
     *    做过A，后面做过任意2个不关心的行为，然后做了C,然后紧接着做了A，中间隔任意不关心的事件后，做过D
     *   A**CA_*D
     */
    val source: BufferedSource = Source.fromFile(new File("D:\\test\\test1.txt"))
    val iter: Iterator[String] = source.getLines()

      iter
        .map(_.split(","))
        .map(e=>{(e(0),e(1),e(2))})
        .toList
        .groupBy(_._1)
        .mapValues(lst=>{
          lst.sortBy(_._3).reduce((x,y)=>("",x._2+y._2,""))._2
        })
        .filter(e => {
          e._2 matches ("^[A-Z]*A\\w{2}CA.*?D.*?")
        }).foreach(println)



      iter
        .map(_.split(","))
        .map(e=>{(e(0),e(1),e(2))})
        .toList
        .groupBy(_._1)
        .mapValues(lst=>{
           lst.sortBy(_._3).map(_._2).mkString("")  matches ("^[A-Z]*A\\w{2}CA.*?D.*?")
        }).foreach(println)

      source.close()
    /**
     * 练习题2：如有如下数据：
     *  [用户id,行为名称,时间戳,会话id],要添加的字段（拆分后的会话Id)
     *   1,A,13,s01  ,ns01
     *   1,B,14,s01  ,ns01
     *   1,C,15,s01  ,ns01
     *   1,C,16,s01  ,ns01
     *   1,A,68,s01  ,ns02
     *   1,A,69,s01  ,ns02
     *   1,C,72,s01  ,ns02
     *   1,D,73,s01  ,ns02
     *   1,A,73,s01  ,ns02
     *   2,B,13,s02  ,ns03
     *   2,A,14,s02  ,ns03
     *   2,C,15,s02  ,ns03
     *   2,A,16,s02  ,ns03
     *   2,D,18,s02  ,ns03
     *   2,E,19,s02  ,ns03
     *   2,C,22,s02  ,ns03
     *   2,D,23,s02  ,ns03
     *   2,A,33,s02  ,ns03
     *
     *  由于咱们公司的app采用了会话保持技术，会让会话时长的计算变得不准确
     *  所以需要去对原始数据做一个会话分割
     *
     */
    val source2: BufferedSource = Source.fromFile(new File("D:\\test\\test2.txt"))
    val iter2 = source2.getLines()
      iter2
        .map(_.split(","))
        .toList
        .groupBy(arr => arr(0).toInt)
        .values
        .map(lst=>lst.sortBy(arr=>arr(2)))
        .toList
        .map(lst=>{
          var num = 1
         val res = for (i <- 0 until lst.size) yield {
            val d = lst(i).:+(num.toString)
            if(i!=(lst.size-1)){
              if(lst(i+1)(2).toInt-lst(i)(2).toInt>20){
                num+=1
              }
            }
            d
          }
          res.toList.map(_.toList)
        }).foreach(println)


    source2.close()




    /**
     * 练习题3：如有如下数据：
     *  用户id,行为名称,时间戳
     *   1,A,13
     *   1,B,14
     *   1,C,15
     *   1,C,16
     *   1,A,18
     *   1,A,19
     *   1,C,22
     *   1,D,23
     *   1,A,33
     *   2,B,13
     *   2,A,14
     *   2,C,15
     *   2,A,16
     *   2,D,18
     *   2,E,19
     *   2,C,22
     *   2,D,23
     *   2,A,33
     *
     *  （漏斗模型）
     *  公司的运营分析师，定义了一条业务路径：  A -> C -> D
     *     请计算，哪些人在这条业务路径上，以及进行到了第几步
     *         u1,2
     *         u2,3
     *         u3,1
     *
     *         /.*?A.*?C.*?D.*?/g
     */

    val source3: BufferedSource = Source.fromFile(new File("D:\\test\\test1.txt"))
    val iter3: Iterator[String] = source3.getLines()
    iter3.map(str=>{
      val arr = str.split(",")
      (arr(0),arr(1),arr(2))
    }).toList
      .groupBy(_._1)
      .mapValues(lst=>lst.sortBy(_._3).map(_._2).mkString(""))
      .map(tp=>{
        val path = tp._2
        val res = path match {
          case s:String if s.matches(".*?A.*?C.*?D.*?") => 3
          case s:String if s.matches(".*?A.*?C") => 2
          case s:String if s.matches(".*?A") => 1
          case _ => 0
        }
        (tp._1,tp._2,res)
      })
      .foreach(println)


    source3.close()


    /**
     * 练习题4：如有如下数据：
     * 有如下数据：  用户：该用户的好友列表
     *  A:B,C,D,F,E,O
     *  B:A,C,E,K
     *  C:F,A,D,I
     *  D:A,E,F,L
     *  E:B,C,D,M,L
     *  F:A,B,C,D,E,O,M
     *  G:A,C,D,E,F
     *  H:A,C,D,E,O
     *  I:A,O
     *  J:B,O
     *  K:A,C,D
     *  L:D,E,F
     *  M:E,F,G
     *  O:A,H,I,J
     *  计算出，这些用户中，哪些用户两两之间有共同好友，以及这些共同的好友都是谁
     *      A 和 B ：  C,E
     *      A 和 C ：  D,F
     */

    val source4: BufferedSource = Source.fromFile(new File("D:\\test\\friends.txt"))
    val iter4: List[String] = source4.getLines().toList
    val dat = iter4.map(str=>{
      val arr = str.split(":")
      val list = arr(1).split(",").toList
      (arr(0),list)
    })
    val buffer = ListBuffer[String]()
    for (i<- 0 until dat.size-1){
      for (j <- i+1 until dat.size ){
        val list = dat(i)._2.intersect(dat(j)._2)
        if(list.nonEmpty){
          buffer.append(dat(i)._1+"和"+ dat(j)._1 + "共同好友："+list)
        }
      }
    }
    buffer.foreach(println)












  }

}
