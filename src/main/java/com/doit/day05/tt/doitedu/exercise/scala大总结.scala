package com.doit.day05.tt.doitedu.exercise

import java.io.File
import scala.io.{BufferedSource, Source}

class scala大总结 {

  def main(args: Array[String]): Unit = {

    // case class 的定义


    // 各类集合的构造  List   Map   Array  Seq   Set



    // 集合上的常用api： map flatMap filter sort groupby  foreach  reduce   sum  max min maxBy  minBy    zip  zipWithIndex


    // ordering 的构造    继承ordered



    // 会写匿名函数


    // 模式匹配


    /**
     * 练习题1：如有如下数据：
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
     *  （行为路径分析）
     *  计算出哪些人满足如下行为要求：
     *    做过A，后面做过任意2个不关心的行为，然后做了C,然后紧接着做了A，中间隔任意不关心的事件后，做过D
     *
     */
    val source: BufferedSource = Source.fromFile(new File("/aaa"))
    val iter: Iterator[String] = source.getLines()



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
     */


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





  }

}
