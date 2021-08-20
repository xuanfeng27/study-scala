package com.doit.day04.tt.demos

/**
 * @author 涛哥
 * @nick_name "deep as the sea"
 * @contact qq:657270652 wx:doit_edu
 * @site www.doitedu.cn
 * @date 2021-08-20
 * @desc 函数，一段逻辑的封装，可以接收输入参数，可以返回处理结果
 * 在scala中，函数本质上是用“类：Function”封装的，一个具体的函数，就是一个对象
 */
object C02_函数定义 {

  def add(a:Int,b:Int):Int = {
    a+b
  }

  val f_add  : (Int, Int) => Int      = (a:Int, b:Int) => { a+b }
  val f_add1 : (Int,Int,Int)=>Int     = (a:Int,b:Int,c:Int)=>{ a+b+c}
  val f_add2 : (String,Int)=>String   = (a:String,b:Int) => { (a.toInt + b).toString  }

  val f_add3 : (String,(Int,Double))=>Boolean     =  (a:String,tp:(Int,Double))=>{

    val res = a.toInt + (tp._1 * tp._2)

    if(res > 10) true else false

  }

  def hallo1(): Unit ={
    println("hallo1")
  }

  def hallo2():String = {
    "hallo2"
  }

  def hallo3(s:String):Unit = {
    println(s)
  }


  def add_plus(a:Int,b:Int,f:(Int,Int)=>Int): Int ={

    f(a,b)

  }

  def main(args: Array[String]): Unit = {

    // 函数最完整的写法
    def add4(a:Int):Int = {a+10}

    // 如果函数体只有一个语句，则函数体的大括号可以省略
    def add5(a:Int):Int = a + 10

    // 如果函数的返回值能够自动推断，则返回值类型也可以省略
    def add6(a:Int)  = a + 10


    val add7             = (a:Int) => { a+ 10 }
    val add8             = (a:Int) =>  a+ 10
    // 如果参数只有一个且类型可推断，则参数列表的圆括号及类型可以省略
    val add9 :  Int=>Int =   a =>  a+ 10

    // 如果函数的参数只出现了一次，则参数变量可以用_代替，且参数列表完全省略
    val add10 : Int=>Int =  _ + 10


    val add11 : (Int,Int)=>Int  =  (a:Int,b:Int)=> { a + b }
    // 参数类型自动推断，省略类型
    val add12 : (Int,Int)=>Int  =  (a,b)=>{a+b}

    // 函数体只有一句话，可以省略大括号
    val add13 : (Int,Int)=>Int  =  (a,b)=> a + b

    // 如果参数只出现一次，则可以用_代替且省略调参数列表
    val add14 : (Int,Int)=>Int  =  (a,b) => a - b
    val add15 : (Int,Int)=>Int  =  _ - _

    val add16 : (Int,Int)=>Int  =  (a,b) => b - a
    val add17 : (Int,Int)=>Int  =  -_ + _


    val judge1:  (Int) => Int=>Int  =    (x:Int) => {
      (y:Int)=>{ x + y  }
    }


    val judge2:  Int => Int=>Int  =    x =>   x + _


    val res: Int => Int = judge2(10)
    // 40
    val i: Int = res(30)

    judge2(10)(30)


  }


}
