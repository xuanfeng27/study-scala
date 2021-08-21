package com.doit.day05.tt.doitedu.demos

object C05_比较器 {

  def main(args: Array[String]): Unit = {

    // 比较器，就是让你定义的某类型的实例，互相之间能够比大小
    // 要能实现比大小，有两种途径：
    // 1. 让你的类型自身变成可比较的(scala中就是去继承 Trait： Ordered； java里面是去实现一个接口 Comparable ）
    val n1:Int = 10
    val n2:Int = 20
    println(n1.compare(n2))
    println(n1 > n2)
    println(n1 >= n2)


    //
    val cupa1 = new CupA(20.0, 40.0)
    val cupa2 = new CupA(15.0, 50.0)
    // cupa1.compare(cup2) 比不了，因为cupA本身是不可比较的

    val cupb1 = new CupB(20.0, 40.0)
    val cupb2 = new CupB(15.0, 50.0)
    cupb1.compareTo(cupb2)
    // println(cupb1 > cupb2)    // CupA实现的是Java中的Comparable接口， 不能用 >  <  >= 这种方法


    val cupc1 = new CupC(20.0, 40.0)
    val cupc2 = new CupC(15.0, 50.0)
    cupc1.compareTo(cupc2)
    // CupA实现的是Scala中的 Ordered 接口，不仅能用compareTo，还可以用compare  , > ,   < 等
    cupc1.compare(cupc2)
    println(cupc1 > cupc2)
    println(cupc1 < cupc2)

    // 2. 专门构造一个  比较器[目标类型]
    // java中是 Compartor   scala中是： Ordering

    // 比较器的比较规则可以灵活构建

    // 比较器1： 按容积比
    val ord1 = new Ordering[CupA](){
      override def compare(x: CupA, y: CupA): Int = (x.width*x.deepth).compare(y.width*y.deepth)
    }

    // 比较器2： 按宽度比
    val ord2 = new Ordering[CupA](){
      override def compare(x: CupA, y: CupA): Int = (x.width).compare(y.width)
    }

    // 【隐式】 比较器3： 按深度比
   implicit val ord3 = new Ordering[CupA](){
      override def compare(x: CupA, y: CupA): Int = (x.deepth).compare(y.deepth)
    }

    ord1.compare(cupa1,cupa2)
    ord1.gt(cupa1,cupa2)
    ord1.lt(cupa1,cupa2)
    ord1.lteq(cupa1,cupa2)

    /**
     * 3, scala的各种需要用到比大小的框架中，都可以利用上述两种途径来比大小
     */


    List(cupb1,cupb2).sorted
    List(cupc1,cupc2).sorted

    // 因为CupA不是一个可比较的，那么，Ordering就没法隐式生成，只能自己传（显式传或者隐式传）
    List(cupa1,cupa2).sorted(ord1)  // 显式传，按ord1的规则比大小：  容积
    List(cupa1,cupa2).sorted(ord2)  // 显式传，按ord1的规则比大小：  宽度
    List(cupa1,cupa2).sorted    //  隐式传，按ord3的规则比大小： 按depth


  }
}

class CupA(val width:Double,val deepth:Double)

class CupB(val width:Double,val deepth:Double) extends Comparable[CupB] {
  override def compareTo(that: CupB): Int = this.width.compare(that.width)
}

class CupC(val width:Double,val deepth:Double) extends Ordered[CupC] {
  override def compare(that: CupC): Int = this.deepth.compare(that.deepth)
}
