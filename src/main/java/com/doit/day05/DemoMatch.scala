package com.doit.day05

object DemoMatch {

  def main(args: Array[String]): Unit = {
    val x: Any = "abc"
    x match {//实现unapply
      case 1 =>"1"
      case "2"=>"2"
      case Person("a",age)  if age > 20 => "age>20"
      case _ => "no"
    }
  }
}

object Person{
  def apply(name: String, age: Int): Person = new Person(name, age)

  def unapply(p: Person): Option[(String, Int)] = {
    if(p==null) None else Some((p.name,p.age))
  }
}
class Person(val name:String,val age:Int){}
