package com.doit.doitedu.demos

import scala.collection.immutable

object C01_基础语法 {

  val a = 1
  var b:Int = _

  def main(args: Array[String]): Unit = {
    val zhangsan = new Aclass("zhangsan", 18)
    zhangsan.name = ""
    zhangsan.age = 19

    val rg: immutable.Seq[Int] = 1 to 10
    val arr = Array(1,2,3,4,5)
    for(i <- arr.indices){

    }



  }
}

class Aclass(var name:String,var age:Int) {

}
