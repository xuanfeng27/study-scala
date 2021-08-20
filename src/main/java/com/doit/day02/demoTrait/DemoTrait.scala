package com.doit.day02.demoTrait

trait DemoTrait {
  val msg:String="msg"

  def eat(str:String):Unit

  def run(): Unit ={
    println("i can run")
  }
}
