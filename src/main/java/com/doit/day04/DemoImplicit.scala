package com.doit.day04

import org.apache.commons.lang3.StringUtils


object DemoImplicit {
  def main(args: Array[String]): Unit = {
    //隐式变量
    implicit  val  age:Int = 19
    //implicit  val age2:Int = 20   //如果找到多个匹配类型的数据就会报错

    def test(implicit age:Int): Unit ={println(age)}
    test

    println("----------------------------华丽分割线-------------------------------------")

    val s:String = "4a"

    // 直接调用string上拥有的toInt方法，对于非数字类型的字符串，就会运行时异常
    //println(s.toInt)


    // 需要你帮我做一个增强版的toIntPlus方法，它对于正确数字字符串可以正常工作，对于非正确数字字符串，得到 0 （而不要产生异常）
   // implicit def strToInt(a:String): A = new A(a) //1，隐式函数

    //2.隐式类
    implicit class B(str:String){
      def toIntPlus()={
        if (StringUtils.isNumeric(str)) str.toInt else 0
      }
    }

    val res:Int = s.toIntPlus()
    println(res)

  }
}

class A (str:String){
  def toIntPlus()={

    if (StringUtils.isNumeric(str)) str.toInt else 0

  /*  var flag = true
    str.toCharArray.foreach(e=>{
     if(!Character.isDigit(e)) {
       flag = false
     }
    })
    if(flag==true) str.toInt else 0*/

  }
}

