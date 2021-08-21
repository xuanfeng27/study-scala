package com.doit.day05.tt.doitedu.demos

import scala.collection.Map


/**
 * @author 涛哥
 * @nick_name "deep as the sea"
 * @contact qq:657270652 wx:doit_edu
 * @site www.doitedu.cn
 * @date 2021-08-21     
 * @desc 模式匹配：判断一个数据是否满足某中模式（ = 一个值，是个List类型，是个List(1,2,_*) ..... ）
 */
object C06_模式匹配 {

  def main(args: Array[String]): Unit = {

    /*
     * 值匹配
     */
    var x:Any = 2
    x match {
      case 1         => println("这就是一个 整数： 1 ")
      case 2         => println("这就是一个 整数： 2 ")
      case "3"       => println("这就是一个字符串 ： 3 ")
      case "doitedu" => println("多易教育就是世界上最伟大的培训机构 ")
      case _         => println("你什么都不是")
    }


    /*
     * 类型匹配
     */
    x = List(1,2,3,4)
    x match {
      case s:String =>  println(s"这就是字符串: $s")
      case s:Int  =>   println(s"这就是整数:  $s" )
      case s:List[String] =>   println(s"这就是String的列表:  $s" )  // 注意： 泛型在这里根本不起约束作用（因为jvm类型的语言都是对泛型擦除的）
      case s:List[Int]  =>   println(s"这就是Int的列表:  $s" )
      case s:Person =>   println(s"这就是一个人:  $s" )
      case s:Map[String,Int] =>   println(s"这就是一个map:  $s" )
      case _   => println("你什么都不是")
    }



    /*
     * 解构匹配 (解构，对应的就是scala中的 unapply 方法）
     * 语法：写类型的apply方法，里面写各种元素约束
     */
    x = List(2,3)
    x = Array(4,5,6)
    x = Map(("a"->1),("b"->2))
    x = (1,5)
    x match {
      case List(2,3) => println(s"你确实是(2,3)的list")
      case List(4,_*) => println(s"你确实是一个以4开头的list")
      case List(1,x,_*) => println(s"你确实是一个以1开头的且至少有两个元素的list，而且第2个元素为：$x")
      case head :: Nil => println(s"你确实是一个至少有1个元素的list，而且我知道你的第一个元素是 $head")
      case head ::second :: Nil => println(s"你确实是一个至少有2个元素的list，而且我知道你的前2个元素是 $head ,$second")
      case Array(4,x,y) if(x.isInstanceOf[Int] & x.asInstanceOf[Int] > 10) => println(s"你确实是一个以4开头且正好有3个元素的Array，而且你的第2元素是整数且>10, 后俩元素分别为： $x , $y")
      case (_,_) => println(s"你确实是一个2元组")
      case (x,y) => println(s"你确实是一个2元组，求元素值为： $x , $y")
      case (1,y) => println(s"你确实是一个2元组且第一元素为1，而且我知道你的第二个元素为： $y")
      case (1,y,_) => println(s"你确实是一个3元组且第一元素为1，而且我知道你的第二个元素为： $y")
      // if 守卫
      case Stu("zs",age,_) if age>20 => println("你是一个名字为zs的Stu，而且我知道你的年龄是:$age")
      case Computor("联想",x) => println("你是一个品牌为联想的Computor，而且我知道你的价格是:$x")
      // case Map(kv1,kv2)  // 不能做解构匹配，因为map类型不支持 unapply 方法
      case _   => println("你什么都不是")
    }
  }
}

case class Stu(name:String,age:Int,height:Int)

class Computor(val brand:String,val price:Double)
object Computor{
  def apply(brand: String, price: Double): Computor = new Computor(brand, price)

  def unapply(computor : Computor): Option[(String, Double)] = {
    if(computor == null) None else Some((computor.brand,computor.price))
  }
}