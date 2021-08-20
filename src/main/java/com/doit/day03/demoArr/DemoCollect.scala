package com.doit.day03.demoArr

//collect支持偏函数
object DemoCollect {
  val f= new PartialFunction[Any,String] {
    override def isDefinedAt(x: Any): Boolean = {
      x.isInstanceOf[String]
    }

    override def apply(v1: Any): String = {
      v1.asInstanceOf[String].toUpperCase
    }
  }

  //偏函数的简写 底层 f2 _
  def f2:PartialFunction[Any,String]={
    case x:String=>x.toUpperCase
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, false, 12.4, "hive", "hello")
    //1
    val list1: List[String] = list.collect(f)//function as param
    println(list1)

    //2
    val list2 = list.collect(f2)
    println(list2)

    //3
    val list3 = list.collect {
      case e: String => e.toUpperCase
    }
    println(list3)

  }
}
