package com.doit.day02.demoTrait

class DemoDog2()  {

}

object DemoDog2 {
  def main(args: Array[String]): Unit = {
    val dog = new DemoDog2 with DemoTrait {
      override def eat(str: String): Unit = {
        println(str)
      }
    }
    dog.eat("dog2 eat")
  }

}
