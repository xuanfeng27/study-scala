package com.doit.doitedu.exercise

object GroupBy练习 {

  def main(args: Array[String]): Unit = {
    println("==================group by 深度练习  =========================")

    val lst5 = List(
      (1, "a", "male", 98.8, "spark"),
      (1, "a", "male", 68.8, "hadoop"),
      (3, "c", "male", 68.8, "hadoop"),
      (2, "b", "female", 88.8, "spark"),
      (2, "b", "female", 68.8, "hadoop"),
      (2, "b", "female", 98.8, "flink"),
      (3, "c", "male", 88.8, "spark")
    )
    // 对数据分组

    // 分组策略1：  按id是否大于25分为两组
    println(lst5.groupBy(tp => tp._1 > 25))
    /**
     * select
     * if(id>25,1,0),  collect_list(array(id,name,sex,score,course))
     * from t
     * group by if(id>25,1,0)
     *
     */


    // 分组策略2：  按性别分组
    val m2: Map[String, List[(Int, String, String, Double, String)]] = lst5.groupBy(tp => tp._3)
    println(m2)
    /**
     * select
     * sex,collect_list(array(id,name,sex,score,course))
     * from t
     * group by sex
     */
    // 继而求出每种性别下的考试成绩最高分  { male->90.8 , female->90.8}
    val func = (lst: List[(Int, String, String, Double, String)]) => {
      // 对拿到list按分数排序
      val sorted = lst.sortBy(tp => tp._4)
      val reversed = sorted.reverse
      val head: (Int, String, String, Double, String) = reversed.head
      return head._4
    }
    m2.mapValues(func)

    // 求出每种性别下的平均成绩
    val avg: Map[String, Double] = m2.mapValues(lst=> {
      lst.map(tp=>tp._4).sum / lst.size
    })


    // 分组策略3：  按姓名的hashcode分为3组
    println(lst5.groupBy(tp => tp._2.hashCode % 3))

    /**
     * select
     * hashcode(name) % 3 as group_name,
     * collect_list(array(id,name,sex,score,course))
     * from t
     * group by hashcode(name) % 3
     */


    // 分组策略4：  按成绩的大小分为3组：  <60  及格  , 60<= .. <80  一般 , >=80 良好
    println(
      lst5.groupBy(tp => {
        tp._4 match {
          case s: Double if s < 60 => "不及格"
          case s: Double if s >= 60 & s < 80 => "一般"
          case _ => "良好"
        }
      })
    )

    /**
     * select
     * case
     * when score<60  then "不及格"
     * when score>=60 and score<80  then "一般"
     * else "良好"
     * end  as group_name,
     * collect_list(array(id,name,sex,score,course))
     *
     * from t
     * group by  case
     * when score<60  then "不及格"
     * when score>=60 and score<80  then "一般"
     * else "良好"
     * end
     */


    // 分组策略5:   性别和科目都相同的，分到同一组
    println(lst5.groupBy(tp => tp._3 + tp._5))

    /**
     * select
     * sex,
     * course,
     * collect_list(array(id,name,sex,score,course))
     * from t
     * group by sex,course
     */

  }


}
