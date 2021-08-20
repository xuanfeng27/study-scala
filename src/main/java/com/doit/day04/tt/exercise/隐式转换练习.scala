package com.doit.day04.tt.exercise

import org.apache.commons.lang3.StringUtils

object 隐式转换练习 {

  def main(args: Array[String]): Unit = {

    val s:String = "80a"

    // 直接调用string上拥有的toInt方法，对于非数字类型的字符串，就会运行时异常
    // println(s.toInt)


    implicit class MyStr(s:String){
      def toIntPlus():Int = if(StringUtils.isNumeric(s)) s.toInt else 0
    }

    // 需要你帮我做一个增强版的toIntPlus方法，它对于正确数字字符串可以正常工作，对于非正确数字字符串，得到 0 （而不要产生异常）
    val res:Int = s.toIntPlus()
    println(res)



  }

}
