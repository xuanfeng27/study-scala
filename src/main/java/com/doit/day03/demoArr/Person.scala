package com.doit.day03.demoArr

case class Person(name:String,age:Int,addr:String) extends Ordered[Person] {
  override def compare(that: Person): Int = {
    this.age-that.age
  }
}
