package com.doit.doitedu.demos

object C08_泛型界定 {

  def main(args: Array[String]): Unit = {


    /*
     *  上、下界
     *  [T >: Comprable]
     *  [T <: Comprable]
     */

    // 上界场景举例
    def max[T <: Ordered[T]](a:T,b:T):T=  {
      if(a > b) a else b
    }
  //max[Mouse1](new Mouse1(1.8),new Mouse1(2.8))  // 报错，因为Mouse1类型不是Ordered的子类
    max[Mouse2](new Mouse2(1.8),new Mouse2(2.8))

    max(new Mouse2(1.8),new Mouse2(2.8))
  //max(new Mouse1(1.8),new Mouse1(2.8))  // 编译依然不会通过



    // 1. 纯语法演示 : 上界
    def f1[T <: Bcls](c:T): Unit = {}
    // f1[Acls](new Acls) 报错，因为Acls是Bcls的基类
    f1[Bcls](new Bcls)
    f1[Ccls](new Ccls)
    f1[Dcls](new Dcls)
    //f1(new Acls) // 就算在调用泛型方法时，没有指定泛型参数，只要实际传入的类型不符合要求，则编译依然报错


    // 2. 纯语法演示 : 下界
    def f2[T >: Bcls](c:T): Unit = { println(c.getClass.getName)}
    f2[Acls](new Acls)
    f2[Bcls](new Bcls)
    //f2[Ccls](new Ccls)  // 如果指定的泛型参数，编译器会检查是否满足下界要求
    //f2[Dcls](new Dcls)

    // 如果不指定泛型参数，而传了一个比B类型要小的类型，按理说不能通过，但是实际上通过了，原因是什么？
    f2(new Ccls)  // 当不指定泛型参数的时候，其实就相当于指定了 Object
    f2(new Dcls)

    /*
     * 上下文界定(Context bounds)
     * 　　 基本介绍
     *         [T : Ordering[T]]  对于T，存在一个隐式转换，能得到 Ordering[T]
     * 　　 上下文界定应用实例
     * 　　　　　－要求：使用上下文界定+隐式参数的方式，比较两个Person对象的年龄大小。使用Ordering实现比较
     *
     *     T : B[T] => 要传入的T类型，必须存在一个隐式变量 B[T]
     */
    //def findBigger[ T : Ordering[T] ](e1:T,e2:T):T= {
      //val cmp = implicitly[Ordering[T]]
      //if(cmp.gt(e1,e2)) e1 else e2
    //}


    implicit val mouse1Ordering:Ordering[Mouse1] = new Ordering[Mouse1] {
      override def compare(x: Mouse1, y: Mouse1): Int = x.price.compareTo(y.price)
    }
    //findBigger[Mouse1](new Mouse1(1.8),new Mouse1(2.8))
    //findBigger[Int](3,5)
    //findBigger[Double](3.5,5.6)
    //findBigger[String]("abc","bbb")

    // 纯语法演示
    def f3 [ T : DoitEmployee ] (e:T)(implicit emp:DoitEmployee[T]): Unit ={}
    implicit val im = new DoitEmployee[DoitStu]
    f3(new DoitStu)

    /*
     * 视图界定(Context bounds)
     * 　　 基本介绍
     * 　　　　　与view bounds一样,context bounds(上下文界定)也是隐式参数的语法糖。
     *         def myCmp2 [T <% Ordering[T]]   存在一个隐式变换，可以把 T 转成 Ordering[T]
     * 　　 视图界定应用实例
     * 　　　　　－要求：使用视图界定+隐式参数的方式，比较两个Person对象的年龄大小。使用Ordering实现比较
     */
    def findBigger2[ T <% Ordered[T] ](e1:T,e2:T):T= {
      if(e1 > e2 ) e1 else e2
    }

    println(findBigger2[Mouse1](new Mouse1(1.8), new Mouse1(2.8)))



  }
}

class Mouse1(val price:Double)
class Mouse2(val price:Double) extends Ordered[Mouse2] {
  override def compare(that: Mouse2): Int = this.price.compare(that.price)
}

class Acls
class Bcls extends Acls
class Ccls extends Bcls
class Dcls extends Bcls

class DoitStu
class DoitEmployee[C]





