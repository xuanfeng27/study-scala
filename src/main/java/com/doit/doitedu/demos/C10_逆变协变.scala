package com.doit.doitedu.demos

object C09_逆变协变 {
  /*
 *    协变：  如果 C > D , 则 A[C] > B[D]   Person > Student  ==> List[Person] > List[Student]
 *    逆变：  如果 C > D , 则 A[C] < B[C]
 *    不变：  尽管C、D存在父子关系，但 A[C] 、A[D] 不存在任何父子关系
 *
 *    里氏原则：
 *    里氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。
 *    里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。
 *    LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。
 */


  def main(args: Array[String]): Unit = {

    val f1 = new MyFunc[String, Animal] {
      override def f(t: String): Animal = {
        val an = new Animal()
        an.category = t.split(",")(0)
        an
      }
    }

    val f2 = new MyFunc[Any, Monkey] {
      override def f(t: Any): Monkey = new Monkey
    }


    // 应用程序
    def test(i: String, myFunc: MyFunc[String, Animal]): String = {
      val an: Animal = myFunc.f(i)
      an.category
    }

    test("elephant,huise", f1)
    test("elephant,huise", f2)

  }
}

// 框架
trait MyFunc[-T, +R] {
  def f(t: T): R
}

class Animal {
  var category: String = "animal"
}

class Monkey extends Animal {
  var color: String = "brown"
}