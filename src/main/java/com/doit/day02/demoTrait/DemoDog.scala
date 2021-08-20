package com.doit.day02.demoTrait

case class DemoDog() extends DemoTrait with DemoTrait2 {

  override def eat(str: String): Unit = {
    println(str)
  }

  override def eat2(str: String): Unit = {
    println(str)
  }
}

object DemoDog {
  def main(args: Array[String]): Unit = {
    val dog =  DemoDog()
    dog.eat("dog eat")
    dog.run()
    println(dog.msg)
  }

}