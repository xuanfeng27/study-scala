package com.doit.day03.demo

object Demo01 {
  def main(args: Array[String]): Unit = {
    //函数两种定义方式
    val d1 = (x:Int,y:Int)=>{x+y}
    val d2: (Int, Int) => Int = (x, y)=>{x+y}
    val d3 = {println(123)}//如果方法没有参数 方法后面的() 可以省略  ,注意在调用的时候也不要书写小括号
    d1(1,2)
    d2(1,2)
    d3
    //注意方法的参数和返回值可以是函数 ,这样的方法称为高阶函数

    //数组排序
    val sorted: Array[Int] = Array[Int](3, 4, 0, 2, 9, 5, 8).sorted
    for (elem <- sorted) {
      print(elem)
    }

    // 将方法转换成函数
    def test(x:Int,y:Int):Int={
      x+y
    }
    val function: (Int, Int) => Int = test _

    // 类默认有一个无参的主构造函数
    class A{}
    val a = new A

    // 1个参数的主构造函数
    class B(val name:Int){}
    val b = new B(3)
    b.name

    //辅助构造函数
    class C{
      var m:Int = _
      var n:Int = _
      def this(m:Int,n:Int)={
        this()//调用主构造函数
        this.m=m
        this.n=n
      }
    }
    val c = new C(2, 4)

  }
}

//伴生对象和伴生类之间可以互相访问彼此的私有属性和私有方法

//样例类
class Demo01(){

}