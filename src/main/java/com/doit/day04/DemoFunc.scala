package com.doit.day04

import java.util.Comparator
import scala.collection.GenTraversableOnce

object DemoFunc {
  def main(args: Array[String]): Unit = {
    def  f (a:String,b:String,c:String,f2:(Int,Int,Int)=>Int)={
      val a1 = a.toInt
      val b1 = b.toInt
      val c1 = c.toInt
      f2(a1,b1,c1)
    }

    println(f("1", "2", "3",List(_, _, _).max))
    println(f("1", "2", "3",List(_, _, _).min))
    println(f("1", "2", "3",List(_, _, _).sum))


    // 创建一个person的list
    val p1 = new Person("a",18,180)
    val p2 = new Person("c",28,170)
    val p3 = new Person("b",16,180)
    val p4 = new Person("d",28,170)

    val lst3 = List(p1,p2,p3,p4)
    //第三种
    lst3.sorted(new Ordering[Person] {
      override def compare(x: Person, y: Person): Int = {
        x.age-y.age
      }
   })

    println(lst3.sorted)

    // 创建一个student的list
    val s1 = new Student("a",18)
    val s2 = new Student("c",28)
    val s3 = new Student("b",16)
    val s4 = new Student("d",28)

    val lst4= List(s1,s2,s3,s4)

    //第二种
    implicit val com = new Comparator[Student] {
      override def compare(o1: Student, o2: Student): Int = o1.age.compare(o2.age)
    }
    println(lst4.sorted)


  }
}

//第一种
class Person(val name:String,val age:Int,val height:Int) extends Comparable[Person]{

  override def toString = s"Person(age=$age,name=$name)"

  override def compareTo(o: Person): Int = this.age.compare(o.age)
}


case class Student(name:String,age:Int){}
