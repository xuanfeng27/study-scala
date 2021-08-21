package com.doit.day05

object DemoOrdered {
  def main(args: Array[String]): Unit = {
    val cup1 = Cup(10, 20)
    val cup2 = Cup(20, 30)

    //scala 比较器
    val comp = new Ordering[Cup] {
      def compare(x: Cup, y: Cup): Int = x.width.compare(y.width)
    }
    comp.compare(cup1,cup2)

    //cupA类可比较
    val cupA1 = CupA(10, 20)
    val cupA2 = CupA(20, 30)
    cupA1.compare(cupA2)
    println(cupA1 > cupA2)

    //cupB类可比较
    val cupB1 = CupB(10, 20)
    val cupB2 = CupB(20, 30)
    cupB1.compareTo(cupB2)


  }
}

case class Cup(width:Double,deepth:Double){}

case class CupA(width:Double,deepth:Double) extends Ordered[CupA]{
  def compare(that: CupA): Int = this.deepth.compare(that.deepth)
}

case class CupB(width:Double,deepth:Double) extends Comparable[CupB]{
  def compareTo(o: CupB): Int = this.width.compare(o.width)
}